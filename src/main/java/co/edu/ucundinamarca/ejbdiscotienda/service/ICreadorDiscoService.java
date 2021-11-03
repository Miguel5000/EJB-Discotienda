/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.CreadorDisco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICreadorDiscoService {
    
    public List<CreadorDisco> obtenerTodos();
    
    public CreadorDisco obtenerPorId(Integer id);
    
    public void crear(CreadorDisco creadorDisco);
    
    public void editar(CreadorDisco creadorDisco);
    
    public void eliminar(CreadorDisco creadorDisco);
    
    public void eliminarPorId(Integer id);
    
}
