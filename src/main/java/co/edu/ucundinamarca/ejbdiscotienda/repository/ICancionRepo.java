/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICancionRepo extends ICrud<Cancion, Integer>{
    
    public List<Cancion> obtenerListaPorCompra(Compra compra);
    
    public List<Cancion> obtenerListaPorDisco(Disco disco);
    
    public Cancion obtenerPorNombreYDisco(String nombre, Disco disco);
    
}
