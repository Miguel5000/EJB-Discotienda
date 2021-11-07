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
 *
 * @author Miguel
 */

@Entity
@Table(name = "roles", schema = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Rol.obtenerTodos", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.obtenerPorNombre" , query = "SELECT r FROM Formato r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Rol.eliminarPorId" , query = "DELETE FROM Rol r WHERE r.id = :id")
})

public class Rol implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "El rol debe tener un nombre")
    @Size(min = 1, max = 15, message = "El nombre no puede superar los 15 caracteres")
    @Column(name = "nombre", nullable = false, length = 15, unique = true)
    private String nombre;
    
    //Relaciones
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> usuarios;

    public Rol() {
    }
    
    public Rol(Integer id, String nombre) {
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
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
