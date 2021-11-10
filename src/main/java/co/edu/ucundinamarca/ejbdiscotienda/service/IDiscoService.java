/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.dto.DiscoDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IDiscoService {
    
    public List<DiscoDto> obtenerTodos() throws ObtencionException;
    
    public DiscoDto obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Disco disco) throws CreacionException;
    
    public void editar(Disco disco) throws ObtencionException;
    
    public void eliminar(Integer id) throws ObtencionException;
    
}
