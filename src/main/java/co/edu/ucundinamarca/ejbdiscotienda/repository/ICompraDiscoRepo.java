/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasDisco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICompraDiscoRepo extends ICrud<CompraDisco, Integer>{
    
    public CompraDisco obtenerPorCompraYDisco(Compra compra, Disco disco);
    public List<VentasDisco> obtenerVentas();
    
}
