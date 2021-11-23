/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CreadorDiscoDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CreadorDiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CreadorDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IArtistaRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICreadorDiscoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IDiscoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.ICreadorDiscoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class CreadorDiscoServiceImp implements ICreadorDiscoService{

    @EJB
    private ICreadorDiscoRepo repo;
    
    @EJB
    private IArtistaRepo repoArtista;
    
    @EJB
    private IDiscoRepo repoDisco;
    
    @Override
    public List<CreadorDiscoDto> obtenerTodos() throws ObtencionException {
        List<CreadorDisco> creacionesDiscos = this.repo.obtenerTodos();
        if(creacionesDiscos == null || creacionesDiscos.isEmpty())
            throw new ObtencionException("No hay creaciones de discos disponibles");
        List<CreadorDiscoDto> creacionesDiscosDto = CreadorDiscoDtoManager.convertir(creacionesDiscos);
        return creacionesDiscosDto;
    }

    @Override
    public CreadorDiscoDto obtenerPorId(Integer id) throws ObtencionException {
        CreadorDisco creacionDisco = this.repo.obtenerPorId(id);
        if(creacionDisco == null)
            throw new ObtencionException("La creación del disco no existe");
        CreadorDiscoDto creacionDiscoDto = CreadorDiscoDtoManager.convertir(creacionDisco);
        return creacionDiscoDto;
    }
    
    @Override
    public CreadorDiscoDto obtenerPorCreadorYDisco(Integer idArtista, Integer idDisco) throws ObtencionException {
        CreadorDisco creacionDisco = this.repo.obtenerPorCreadorYDisco(idArtista, idDisco);
        if(creacionDisco == null)
            throw new ObtencionException("La creación del disco no existe");
        CreadorDiscoDto creacionDiscoDto = CreadorDiscoDtoManager.convertir(creacionDisco);
        return creacionDiscoDto; 
    }

    @Override
    public void crear(CreadorDisco creacionDisco) throws CreacionException {
        //Validaciones
        if(creacionDisco.getId() != null)
            throw new CreacionException("El id de la creación del disco es autoincremental");
        
        //Artista
        Artista artista = creacionDisco.getArtista();
        
        if(artista.getId() == null)
            throw new CreacionException("La creación de artistas en la inserción de creaciones de discos no está permitida");
        
        if(this.repoArtista.obtenerPorId(artista.getId()) == null)
            throw new CreacionException("No existe el artista con el que intenta vincular la creación del disco");

        //Disco
        Disco disco = creacionDisco.getDisco();
        
        if(disco.getId() == null)
            throw new CreacionException("La creación de discos en la inserción de creaciones de discos no está permitida");
        
        if(this.repoDisco.obtenerPorId(disco.getId()) == null)
            throw new CreacionException("No existe el disco con el que intenta vincular la creación del disco");
        
        //Validaciones relaciones
        if(this.repo.obtenerPorCreadorYDisco(artista.getId(), disco.getId()) != null)
            throw new CreacionException("Un mismo artista no puede tener el mismo disco registrado 2 veces");
        
        this.repo.crear(creacionDisco);
    }

    @Override
    public void editar(CreadorDisco creacionDisco) throws ObtencionException, EdicionException {
        if(creacionDisco.getId() == null || this.repo.obtenerPorId(creacionDisco.getId()) == null)
            throw new ObtencionException("La creación de disco a editar no existe");
        
        //Artista
        Artista artista = creacionDisco.getArtista();
        
        if(artista.getId() == null)
            throw new EdicionException("El artista debe tener un id");
        
        if(this.repoArtista.obtenerPorId(artista.getId()) == null)
            throw new EdicionException("No existe el artista con el que intenta vincular la creación del disco");

        //Disco
        Disco disco = creacionDisco.getDisco();
        
        if(disco.getId() == null)
            throw new EdicionException("El disco debe tener un id");
        
        if(this.repoDisco.obtenerPorId(disco.getId()) == null)
            throw new EdicionException("No existe el disco con el que intenta vincular la creación del disco");
        
        //Validaciones relaciones
        CreadorDisco creacionDiscoPorCreacionYDisco = this.repo.obtenerPorCreadorYDisco(artista.getId(), disco.getId());
        
        if(creacionDiscoPorCreacionYDisco != null && creacionDiscoPorCreacionYDisco.getId().intValue() != creacionDisco.getId())
            throw new EdicionException("Un mismo artista no puede tener el mismo disco registrado 2 veces");
        
        this.repo.editar(creacionDisco);
    }

    @Override
    public void eliminar(Integer id) throws ObtencionException {
        CreadorDisco creacionDisco = this.repo.obtenerPorId(id);
        if(creacionDisco == null)
            throw new ObtencionException("La creación del disco a eliminar no existe");
        this.repo.eliminar(id);
    }
    
}
