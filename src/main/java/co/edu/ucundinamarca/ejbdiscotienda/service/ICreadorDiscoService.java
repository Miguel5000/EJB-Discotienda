/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.CreadorDisco;
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
public interface ICreadorDiscoService {
    
    public List<CreadorDisco> obtenerTodos() throws ObtencionException;
    
    public CreadorDisco obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(CreadorDisco creadorDisco) throws CreacionException;
    
    public void editar(CreadorDisco creadorDisco) throws ObtencionException, EdicionException;
    
    public void eliminar(CreadorDisco creadorDisco) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
}
