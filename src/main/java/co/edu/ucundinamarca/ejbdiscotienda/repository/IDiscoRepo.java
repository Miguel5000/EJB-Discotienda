/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IDiscoRepo extends ICrud<Disco, Integer> {
    
    public List<Disco> obtenerListaPorArtista(Integer id);
    public List<Disco> obtenerListaPorCompra(Compra compra);
    public Disco obtenerPorNombreYArtista(String nombre, Artista artista);
    public Disco crearConRetorno(Disco disco);
    
}
