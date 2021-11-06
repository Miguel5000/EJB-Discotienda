/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.dto.GeneroDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Genero;
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
public interface IGeneroService {
    
    public List<GeneroDto> obtenerTodos() throws ObtencionException;
    
    public GeneroDto obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Genero genero) throws CreacionException;
    
    public void editar(Genero genero) throws ObtencionException, EdicionException;
    
    public void eliminar(Genero genero) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
}
