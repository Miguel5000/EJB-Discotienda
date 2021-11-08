/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.FormatoDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.FormatoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Formato;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IFormatoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.IFormatoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class FormatoServiceImp implements IFormatoService{

    @EJB
    private IFormatoRepo repo;
    
    @Override
    public List<FormatoDto> obtenerTodos() throws ObtencionException {
        List<Formato> formatos = this.repo.obtenerTodos();
        if(formatos == null || formatos.isEmpty())
            throw new ObtencionException("No hay formatos disponibles");
        List<FormatoDto> formatosDto = FormatoDtoManager.convertir(formatos);
        return formatosDto;
    }

    @Override
    public FormatoDto obtenerPorId(Integer id) throws ObtencionException {
        Formato formato = this.repo.obtenerPorId(id);
        if(formato == null)
            throw new ObtencionException("El formato no existe");
        FormatoDto formatoDto = FormatoDtoManager.convertir(formato);
        return formatoDto;
    }

    @Override
    public void crear(Formato formato) throws CreacionException {
        //Validaciones
        if(formato.getId() != null)
            throw new CreacionException("El id del formato es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(formato.getCanciones() != null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        //Validaciones unicidad
        if(this.repo.obtenerPorNombre(formato.getNombre()) != null)
            throw new CreacionException("Ya existe un formato con ese nombre");
        
        this.repo.crear(formato);
    }

    @Override
    public void editar(Formato formato) throws ObtencionException, EdicionException {
        if(formato.getId() == null || this.repo.obtenerPorId(formato.getId()) == null)
            throw new ObtencionException("El formato a editar no existe");
        
        //Validaciones unicidad
        if(this.repo.obtenerPorNombre(formato.getNombre()).getId().intValue() != formato.getId().intValue())
            throw new EdicionException("Ya existe un formato con ese nombre");
        
        this.repo.editar(formato);
    }

    @Override
    public void eliminar(Formato formato) throws ObtencionException {
        if(formato.getId() == null || this.repo.obtenerPorId(formato.getId()) == null)
            throw new ObtencionException("El formato a eliminar no existe");
        this.repo.eliminar(formato);
    }

    @Override
    public void eliminarPorId(Integer id) throws ObtencionException {
        Formato formato = this.repo.obtenerPorId(id);
        if(formato == null)
            throw new ObtencionException("El formato a eliminar no existe");
        this.repo.eliminarPorId(id);
    }
    
}
