/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.dto.RolDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Rol;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IRolService {
    
    public List<RolDto> obtenerTodos() throws ObtencionException;
    
    public RolDto obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Rol rol) throws CreacionException;
    
    public void editar(Rol rol) throws ObtencionException, EdicionException;
    
    public void eliminar(Rol rol) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
}
