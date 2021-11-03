/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IRolService {
    
    public List<Rol> obtenerTodos();
    
    public Rol obtenerPorId(Integer id);
    
    public void crear(Rol rol);
    
    public void editar(Rol rol);
    
    public void eliminar(Rol rol);
    
    public void eliminarPorId(Integer id);
    
}
