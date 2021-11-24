/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CompraDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Carrito;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
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
public interface ICompraService{
    
    public List<CompraDto> obtenerTodos() throws ObtencionException;
    
    public CompraDto obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Compra compra) throws CreacionException;
    
    public void editar(Compra compra) throws ObtencionException, EdicionException;

    public void eliminar(Integer id) throws ObtencionException;
    
    public void comprar(Integer id) throws ObtencionException;
    
    public Carrito obtenerCarrito(Integer id) throws ObtencionException;
    
    public CompraDto obtenerCompraCarrito(Integer id) throws ObtencionException;
    
}
