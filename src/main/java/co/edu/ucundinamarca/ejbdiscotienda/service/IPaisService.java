/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Pais;
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
public interface IPaisService {
    
    public List<Pais> obtenerTodos() throws ObtencionException;
    
    public Pais obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Pais pais) throws CreacionException;
    
    public void editar(Pais pais) throws ObtencionException, EdicionException;
    
    public void eliminar(Pais pais) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
}
