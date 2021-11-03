/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICompraService{
    
    public List<Compra> obtenerTodos();
    
    public Compra obtenerPorId(Integer id);
    
    public void crear(Compra compra);
    
    public void editar(Compra compra);
    
    public void eliminar(Compra compra);
    
    public void eliminarPorId(Integer id);
    
    public void comprar(Compra compra);
    
    public Compra obtenerCarrito(Usuario usuario);
    
}
