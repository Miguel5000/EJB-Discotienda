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
        
        //Validaciones
        
        if(artista.getId() != null)
            throw new CreacionException("El id del artista es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(artista.getCreaciones() != null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        //Género
        Genero genero = artista.getGenero();
        
        if(genero.getId() == null)
            throw new CreacionException("La creación de géneros en la inserción de artistas no está permitida");
        
        if(this.repoGenero.obtenerPorId(genero.getId()) == null)
            throw new CreacionException("No existe el género con el que intenta vincular al artista");

        //País
        Pais pais = artista.getPais();
        
        if(pais.getId() == null)
            throw new CreacionException("La creación de paises en la inserción de artistas no está permitida");
        
        if(this.repoPais.obtenerPorId(pais.getId()) == null)
            throw new CreacionException("No existe el país con el que intenta vincular al artista");
        
        this.repo.crear(artista);
        
    }

    @Override
    public void editar(Artista artista) throws ObtencionException, EdicionException {
        if(artista.getId() == null || this.repo.obtenerPorId(artista.getId()) == null)
            throw new ObtencionException("El artista a editar no existe");
        if(artista.getFoto() != null)
            throw new EdicionException("No se puede suministrar la url de la foto, el sistema la genera a partir de la cadena en base 64");
        
        //Género
        Genero genero = artista.getGenero();
        
        if(genero.getId() == null)
            throw new EdicionException("El género debe tener un id");
        
        if(this.repoGenero.obtenerPorId(genero.getId()) == null)
            throw new EdicionException("No existe el género con el que intenta vincular al artista");

        //País
        Pais pais = artista.getPais();
        
        if(pais.getId() == null)
            throw new EdicionException("El país debe tener un id");
        
        if(this.repoPais.obtenerPorId(pais.getId()) == null)
            throw new EdicionException("No existe el país con el que intenta vincular al artista");

        this.repo.editar(artista);
    }

    @Override
    public void eliminar(Integer id) throws ObtencionException {
        Artista artista = this.repo.obtenerPorId(id);
        if(artista == null)
            throw new ObtencionException("El artista a eliminar no existe");
        this.repo.eliminar(id);
    }

    @Override
    public List<VentasArtista> obtenerVentas() throws ObtencionException {
        List<VentasArtista> ventas = this.repo.obtenerVentas();
        if(ventas == null || ventas.isEmpty())
            throw new ObtencionException("No se ha realizado ninguna venta");
        return ventas;
    }
    
}
