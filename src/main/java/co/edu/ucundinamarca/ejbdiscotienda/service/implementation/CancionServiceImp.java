/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CancionDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CancionDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Formato;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICancionRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IDiscoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IFormatoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.ICancionService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class CancionServiceImp implements ICancionService{

    @EJB
    private ICancionRepo repo;
    
    @EJB
    private IFormatoRepo repoFormato;
    
    @EJB
    private IDiscoRepo repoDisco;
    
    @Override
    public List<CancionDto> obtenerTodos() throws ObtencionException {
        List<Cancion> canciones = this.repo.obtenerTodos();
        if(canciones == null || canciones.isEmpty())
            throw new ObtencionException("No hay canciones disponibles");
        List<CancionDto> cancionesDto = CancionDtoManager.convertir(canciones);
        return cancionesDto;
    }

    @Override
    public CancionDto obtenerPorId(Integer id) throws ObtencionException {
        Cancion cancion = this.repo.obtenerPorId(id);
        if(cancion == null)
            throw new ObtencionException("La canción no existe");
        CancionDto cancionDto = CancionDtoManager.convertir(cancion);
        return cancionDto;
    }

    @Override
    public void crear(Cancion cancion) throws CreacionException {
        //Validaciones
        if(cancion.getId() != null)
            throw new CreacionException("El id de la canción es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(cancion.getCompras() != null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        //Formato
        Formato formato = cancion.getFormato();
        
        if(formato.getId() == null)
            throw new CreacionException("La creación de formatos en la inserción de canciones no está permitida");
        
        if(this.repoFormato.obtenerPorId(formato.getId()) == null)
            throw new CreacionException("No existe el formato con el que intenta vincular la canción");

        //Disco
        Disco disco = cancion.getDisco();
        
        if(disco.getId() == null)
            throw new CreacionException("La creación de discos en la inserción de canciones no está permitida");
        
        if(this.repoDisco.obtenerPorId(disco.getId()) == null)
            throw new CreacionException("No existe el disco con el que intenta vincular la canción");
        
        //Validaciones en relaciones
        if(this.repo.obtenerPorNombreYDisco(cancion.getNombre(), cancion.getDisco()) != null)
            throw new CreacionException("Ya existe una canción con ese nombre en el disco");
        
        this.repo.crear(cancion);
    }

    @Override
    public void editar(Cancion cancion) throws ObtencionException, EdicionException {
        if(cancion.getId() == null || this.repo.obtenerPorId(cancion.getId()) == null)
            throw new ObtencionException("La canción a editar no existe");
        //Formato
        Formato formato = cancion.getFormato();
        
        if(formato.getId() == null)
            throw new EdicionException("El formato debe tener un id");
        
        if(this.repoFormato.obtenerPorId(formato.getId()) == null)
            throw new EdicionException("No existe el formato con el que intenta vincular la canción");

        //Disco
        Disco disco = cancion.getDisco();
        
        if(disco.getId() == null)
            throw new EdicionException("El disco debe tener un id");
        
        if(this.repoDisco.obtenerPorId(disco.getId()) == null)
            throw new EdicionException("No existe el disco con el que intenta vincular la canción");
        
        //Validaciones en relaciones
        if(this.repo.obtenerPorNombreYDisco(cancion.getNombre(), cancion.getDisco()).getId().intValue() != cancion.getId().intValue()) 
            throw new EdicionException("Ya existe una canción con ese nombre en el disco");
        
        this.repo.editar(cancion);
        
    }

    @Override
    public void eliminar(Cancion cancion) throws ObtencionException {
        if(cancion.getId() == null || this.repo.obtenerPorId(cancion.getId()) == null)
            throw new ObtencionException("La canción a eliminar no existe");
        this.repo.eliminar(cancion);
    }

    @Override
    public void eliminarPorId(Integer id) throws ObtencionException {
        Cancion cancion = this.repo.obtenerPorId(id);
        if(cancion == null)
            throw new ObtencionException("La canción a eliminar no existe");
        this.repo.eliminarPorId(id);
    }

    @Override
    public List<CancionDto> obtenerListaPorCompra(Compra compra) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CancionDto> obtenerListaPorDisco(Disco disco) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
