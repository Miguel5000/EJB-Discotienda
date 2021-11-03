/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICompraDiscoService {
    
    public List<CompraDisco> obtenerTodos();
    
    public CompraDisco obtenerPorId(Integer id);
    
    public void crear(CompraDisco compraDisco);
    
    public void editar(CompraDisco compraDisco);
    
    public void eliminar(CompraDisco compraDisco);
    
    public void eliminarPorId(Integer id);
    
    public void retirarDisco(Disco disco, Compra compra);
    
}
