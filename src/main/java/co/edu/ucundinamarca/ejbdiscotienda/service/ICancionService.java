/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CancionDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
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
public interface ICancionService {
    
    public List<CancionDto> obtenerTodos() throws ObtencionException;
    
    public CancionDto obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Cancion cancion) throws CreacionException;
    
    public void editar(Cancion cancion) throws ObtencionException, EdicionException;
    
    public void eliminar(Integer id) throws ObtencionException;
    
    public List<CancionDto> obtenerListaPorCompra(Integer id) throws ObtencionException;
    
    public List<CancionDto> obtenerListaPorDisco(Integer id) throws ObtencionException;
    
}
