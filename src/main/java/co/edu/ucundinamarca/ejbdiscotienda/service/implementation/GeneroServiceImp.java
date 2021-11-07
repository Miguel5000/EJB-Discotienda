/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.GeneroDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.GeneroDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Genero;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IGeneroRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.IGeneroService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class GeneroServiceImp implements IGeneroService{

    @EJB
    private IGeneroRepo repo;
    
    @Override
    public List<GeneroDto> obtenerTodos() throws ObtencionException {
        List<Genero> generos = this.repo.obtenerTodos();
        if(generos == null || generos.isEmpty())
            throw new ObtencionException("No hay géneros disponibles");
        List<GeneroDto> generosDto = GeneroDtoManager.convertir(generos);
        return generosDto;
    }

    @Override
    public GeneroDto obtenerPorId(Integer id) throws ObtencionException {
        Genero genero = this.repo.obtenerPorId(id);
        if(genero == null)
            throw new ObtencionException("El género no existe");
        GeneroDto generoDto = GeneroDtoManager.convertir(genero);
        return generoDto;
    }

    @Override
    public void crear(Genero genero) throws CreacionException {
        //Validaciones
        if(genero.getId() != null)
            throw new CreacionException("El id del género es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(genero.getArtistas()!= null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        //Validaciones unicidad
        if(this.repo.obtenerPorNombre(genero.getNombre()) != null)
            throw new CreacionException("Ya existe un género con ese nombre");
        
        this.repo.crear(genero);
    }

    @Override
    public void editar(Genero genero) throws ObtencionException, EdicionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Genero genero) throws ObtencionException {
        if(genero.getId() == null || this.repo.obtenerPorId(genero.getId()) == null)
            throw new ObtencionException("El género a eliminar no existe");
        this.repo.eliminar(genero);
    }

    @Override
    public void eliminarPorId(Integer id) throws ObtencionException {
        Genero genero = this.repo.obtenerPorId(id);
        if(genero == null)
            throw new ObtencionException("El género a eliminar no existe");
        this.repo.eliminarPorId(id);
    }
    
}
