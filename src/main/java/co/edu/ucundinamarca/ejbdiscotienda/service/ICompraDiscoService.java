/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasDisco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICompraDiscoService {
    
    public List<CompraDisco> obtenerTodos() throws ObtencionException;
    
    public CompraDisco obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(CompraDisco compraDisco) throws CreacionException;
    
    public void editar(CompraDisco compraDisco) throws ObtencionException, EdicionException;
    
    public void eliminar(CompraDisco compraDisco) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
    public void retirarDisco(Disco disco, Compra compra) throws ObtencionException;
    
    public List<VentasDisco> obtenerVentas() throws ObtencionException;
    
}
