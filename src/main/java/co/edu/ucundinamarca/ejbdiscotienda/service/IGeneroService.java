/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Genero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IGeneroService {
    
    public List<Genero> obtenerTodos();
    
    public Genero obtenerPorId(Integer id);
    
    public void crear(Genero genero);
    
    public void editar(Genero genero);
    
    public void eliminar(Genero genero);
    
    public void eliminarPorId(Integer id);
    
}
