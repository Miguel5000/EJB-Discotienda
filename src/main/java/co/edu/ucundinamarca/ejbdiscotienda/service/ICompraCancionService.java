/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CompraCancionDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraCancion;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasCancion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICompraCancionService{
    
    public List<CompraCancionDto> obtenerTodos() throws ObtencionException;
    
    public CompraCancionDto obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(CompraCancion compraCancion) throws CreacionException;
    
    public void editar(CompraCancion compraCancion) throws ObtencionException, EdicionException;
    
    public void eliminar(CompraCancion compraCancion) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
    public void retirarCancion(Cancion cancion, Compra compra) throws ObtencionException;
    
    public List<VentasCancion> obtenerVentas() throws ObtencionException;
    
}
