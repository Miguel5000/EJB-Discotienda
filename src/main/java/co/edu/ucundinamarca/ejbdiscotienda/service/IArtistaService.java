/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.dto.ArtistaDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasArtista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IArtistaService {
    
    public List<ArtistaDto> obtenerTodos() throws ObtencionException;
    
    public ArtistaDto obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Artista artista) throws CreacionException;
    
    public void editar(Artista artista) throws ObtencionException, EdicionException;

    public void eliminar(Integer id) throws ObtencionException;
    
    public List<VentasArtista> obtenerVentas() throws ObtencionException;
    
}
