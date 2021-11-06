/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto;

import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.ArtistaDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class PaisDto {
    

    private Integer id;
    private String nombre;
    private List<ArtistaDto> artistas;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the artistas
     */
    public List<ArtistaDto> getArtistas() {
        return artistas;
    }

    /**
     * @param artistas the artistas to set
     */
    public void setArtistas(List<Artista> artistas) {
        this.artistas = ArtistaDtoManager.convertir(artistas);
    }
    
    
    
}
