/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraCancion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICompraCancionService{
    
    public List<CompraCancion> obtenerTodos();
    
    public CompraCancion obtenerPorId(Integer id);
    
    public void crear(CompraCancion compraCancion);
    
    public void editar(CompraCancion compraCancion);
    
    public void eliminar(CompraCancion compraCancion);
    
    public void eliminarPorId(Integer id);
    
    public void retirarCancion(Cancion cancion, Compra compra);
    
}
