/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Pais;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IPaisService {
    
    public List<Pais> obtenerTodos();
    
    public Pais obtenerPorId(Integer id);
    
    public void crear(Pais pais);
    
    public void editar(Pais pais);
    
    public void eliminar(Pais pais);
    
    public void eliminarPorId(Integer id);
    
}
