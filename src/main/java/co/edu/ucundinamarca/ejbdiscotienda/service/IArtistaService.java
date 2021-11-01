/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IArtistaService {
    
    public List<Artista> obtenerTodos();
    
    public Artista obtenerPorId(Integer id);
    
    public void crear(Artista artista);
    
    public void editar(Artista artista);
    
    public void eliminar(Artista artista);
    
    public void eliminarPorId(Integer id);
    
    public Integer obtenerCantidadVentas(Artista artista);
    
}
