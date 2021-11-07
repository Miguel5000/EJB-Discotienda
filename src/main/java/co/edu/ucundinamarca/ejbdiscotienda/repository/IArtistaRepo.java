/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasArtista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IArtistaRepo extends ICrud<Artista, Integer>{
 
    public List<VentasArtista> obtenerVentas();
    
    public Artista obtenerPorFoto(String foto);
    
}
