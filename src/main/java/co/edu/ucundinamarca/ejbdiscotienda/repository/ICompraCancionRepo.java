/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraCancion;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICompraCancionRepo extends ICrud<CompraCancion, Integer>{
    
    public CompraCancion obtenerPorCompraYCancion(Compra compra, Cancion cancion);
    public Integer obtenerCantidadVentas(Cancion cancion);
    
}
