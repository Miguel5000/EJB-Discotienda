/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Clase que representa a la entidad creador_disco
 * @author Miguel Ángel Manrique Téllez
 * @since 1.0.0
 * @version 1.0.0
 */
@Entity
@Table(name = "creadores_discos", schema = "creadores_discos")
@NamedQueries({
    @NamedQuery(name = "CreadorDisco.obtenerTodos", query = "SELECT c FROM CreadorDisco c"),
    @NamedQuery(name = "CreadorDisco.obtenerPorCreadorYDisco", query = "SELECT c FROM CreadorDisco c WHERE c.artista.id = :idArtista AND c.disco.id = :idDisco"),
    @NamedQuery(name = "CreadorDisco.eliminarPorId" , query = "DELETE FROM CreadorDisco c WHERE c.id = :id")
})

public class CreadorDisco implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    //Relaciones
    
    @NotNull(message = "La creación de disco debe tener un artista asociado")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
    
    @NotNull(message = "La creación del disco debe tener un disco asociado")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disco", nullable = false)
    private Disco disco;

    public CreadorDisco() {
    }

    public CreadorDisco(Integer id) {
        this.id = id;
    }

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
     * @return the artista
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    /**
     * @return the disco
     */
    public Disco getDisco() {
        return disco;
    }

    /**
     * @param disco the disco to set
     */
    public void setDisco(Disco disco) {
        this.disco = disco;
    }
    
    
    
}
