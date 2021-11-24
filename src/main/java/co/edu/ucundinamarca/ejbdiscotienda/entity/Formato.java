/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa a la entidad formato
 * @author Miguel Ángel Manrique Téllez
 * @since 1.0.0
 * @version 1.0.0
 */
@Entity
@Table(name = "formatos", schema = "canciones")
@NamedQueries({
    @NamedQuery(name = "Formato.obtenerTodos", query = "SELECT f FROM Formato f"),
    @NamedQuery(name = "Formato.obtenerPorNombre" , query = "SELECT f FROM Formato f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Formato.eliminarPorId" , query = "DELETE FROM Formato f WHERE f.id = :id")
})

public class Formato implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "El formato debe tener un nombre")
    @Size(min = 1, max = 5, message = "El nombre no puede superar los 5 caracteres")
    @Column(name = "nombre", nullable = false, length = 5, unique = true)
    private String nombre;

    //Relaciones
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "formato", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancion> canciones;
    
    public Formato() {
    }

    public Formato(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
     * @return the canciones
     */
    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    
    
}
