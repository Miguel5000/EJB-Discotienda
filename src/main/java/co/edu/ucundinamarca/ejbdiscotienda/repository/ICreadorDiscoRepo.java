/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CreadorDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface ICreadorDiscoRepo extends ICrud<CreadorDisco, Integer>{
    
    public CreadorDisco obtenerPorCreadorYDisco(Integer idArtista, Integer idDisco);
    
}
