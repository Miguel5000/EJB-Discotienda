/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.RolDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.RolDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Rol;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IRolRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.IRolService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class RolServiceImp implements IRolService{

    @EJB
    private IRolRepo repo;
    
    @Override
    public List<RolDto> obtenerTodos() throws ObtencionException {
        List<Rol> roles = this.repo.obtenerTodos();
        if(roles == null || roles.isEmpty())
            throw new ObtencionException("No hay roles disponibles");
        List<RolDto> rolesDto = RolDtoManager.convertir(roles);
        return rolesDto;
    }

    @Override
    public RolDto obtenerPorId(Integer id) throws ObtencionException {
        Rol rol = this.repo.obtenerPorId(id);
        if(rol == null)
            throw new ObtencionException("El rol no existe");
        RolDto rolDto = RolDtoManager.convertir(rol);
        return rolDto;
    }

    @Override
    public void crear(Rol rol) throws CreacionException {
        //Validaciones
        if(rol.getId() != null)
            throw new CreacionException("El id del rol es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(rol.getUsuarios()!= null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        //Validaciones unicidad
        if(this.repo.obtenerPorNombre(rol.getNombre()) != null)
            throw new CreacionException("Ya existe un rol con ese nombre");
        
        this.repo.crear(rol);
    }

    @Override
    public void editar(Rol rol) throws ObtencionException, EdicionException {
        if(rol.getId() == null || this.repo.obtenerPorId(rol.getId()) == null)
            throw new ObtencionException("El rol a editar no existe");
        
        //Validaciones unicidad
        if(this.repo.obtenerPorNombre(rol.getNombre()).getId().intValue() != rol.getId().intValue())
            throw new EdicionException("Ya existe un rol con ese nombre");
        
        this.repo.editar(rol);
    }

    @Override
    public void eliminar(Rol rol) throws ObtencionException {
        if(rol.getId() == null || this.repo.obtenerPorId(rol.getId()) == null)
            throw new ObtencionException("El rol a eliminar no existe");
        this.repo.eliminar(rol);
    }

    @Override
    public void eliminarPorId(Integer id) throws ObtencionException {
        Rol rol = this.repo.obtenerPorId(id);
        if(rol == null)
            throw new ObtencionException("El rol a eliminar no existe");
        this.repo.eliminarPorId(id);
    }
    
}
