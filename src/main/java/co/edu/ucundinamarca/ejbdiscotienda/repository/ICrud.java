/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository;

import java.util.List;

/**
 *
 * @author Miguel
 */
public interface ICrud<Entidad, TipoLlavePrimaria> {
    
    public List<Entidad> obtenerTodos();
    
    public Entidad obtenerPorId(TipoLlavePrimaria id);
    
    public void crear(Entidad entidad);
    
    public void editar(Entidad entidad);

    public void eliminar(TipoLlavePrimaria id);
    
}
