/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.dto.FormatoDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Formato;
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
public interface IFormatoService {
    
    public List<FormatoDto> obtenerTodos() throws ObtencionException;
    
    public FormatoDto obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Formato formato) throws CreacionException;
    
    public void editar(Formato formato) throws ObtencionException, EdicionException;
    
    public void eliminar(Formato formato) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
}
