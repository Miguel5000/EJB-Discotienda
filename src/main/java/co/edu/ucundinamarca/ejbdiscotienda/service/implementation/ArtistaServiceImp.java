/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.ArtistaDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.ArtistaDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Genero;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Pais;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IArtistaRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IGeneroRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IPaisRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.IArtistaService;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasArtista;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class ArtistaServiceImp implements IArtistaService{

    @EJB
    private IArtistaRepo repo;
    
    @EJB
    private IGeneroRepo repoGenero;
    
    @EJB
    private IPaisRepo repoPais;
    
    @Override
    public List<ArtistaDto> obtenerTodos() throws ObtencionException {
        List<Artista> artistas = this.repo.obtenerTodos();
        if(artistas == null || artistas.isEmpty())
            throw new ObtencionException("No hay artistas disponibles");
        List<ArtistaDto> artistasDto = ArtistaDtoManager.convertir(artistas);
        return artistasDto;
    }

    @Override
    public ArtistaDto obtenerPorId(Integer id) throws ObtencionException {
        Artista artista = this.repo.obtenerPorId(id);
        if(artista == null)
            throw new ObtencionException("El artista no existe");
        ArtistaDto artistaDto = ArtistaDtoManager.convertir(artista);
        return artistaDto;
    }

    @Override
    public void crear(Artista artista) throws CreacionException {
        
        //Creación de foto en servidor
        //Asignación de foto al artista
        
        Artista artistaExistente = this.repo.obtenerPorFoto(artista.getFoto());
        if(artistaExistente != null)
            throw new CreacionException("Ya existe un artista con esa foto");
        
        //Validaciones
        //Muchos a uno
        //Género
        Genero genero = artista.getGenero();
        
        //(Existente)
        if(genero.getId() != null && repoGenero.obtenerPorId(genero.getId()) == null)
            throw new CreacionException("No existe el género con el que intenta vincular al artista");
        
        //(Nuevo)
        if(genero.getId() == null && repoGenero.obtenerPorNombre(genero.getNombre()) != null)
            throw new CreacionException("Ya existe un género con ese nombre");
        
        //País
        Pais pais = artista.getPais();
        
        //(Existente)
        if(pais.getId() != null && repoPais.obtenerPorId(pais.getId()) == null)
            throw new CreacionException("No existe el país con el que intenta vincular al artista");
        
        //(Nuevo)
        if(pais.getId() == null && repoPais.obtenerPorNombre(pais.getNombre()) != null)
            throw new CreacionException("Ya existe un país con ese nombre");
        
        //Uno a muchos
        
        
    }

    @Override
    public void editar(Artista artista) throws ObtencionException, EdicionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Artista artista) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(Integer id) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentasArtista> obtenerVentas() throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
