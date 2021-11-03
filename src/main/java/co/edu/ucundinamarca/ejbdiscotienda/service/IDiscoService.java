/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IDiscoService {
    
    public List<Disco> obtenerTodos() throws ObtencionException;
    
    public Disco obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Disco disco);
    
    public void editar(Disco disco) throws ObtencionException;
    
    public void eliminar(Disco disco) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
}
