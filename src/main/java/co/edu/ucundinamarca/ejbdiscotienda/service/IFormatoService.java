/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Formato;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IFormatoService {
    
    public List<Formato> obtenerTodos();
    
    public Formato obtenerPorId(Integer id);
    
    public void crear(Formato formato);
    
    public void editar(Formato formato);
    
    public void eliminar(Formato formato);
    
    public void eliminarPorId(Integer id);
    
}
