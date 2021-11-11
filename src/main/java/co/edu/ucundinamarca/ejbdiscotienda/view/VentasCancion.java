/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.view;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Miguel
 */

@Entity
@Table(name = "ventas_canciones", schema = "compras")
@NamedQueries({
    @NamedQuery(name = "VentasCancion.obtenerTodos", query = "SELECT v FROM VentasCancion v"),
})

public class VentasCancion {
    
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "id_disco")
    private Integer idDisco;
    
    @Column(name = "id_formato")
    private Integer idFormato;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "precio")
    private Integer precio;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "duracion")
    private Time duracion;
    
    @Column(name = "ventas")
    private Integer ventas;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the idDisco
     */
    public Integer getIdDisco() {
        return idDisco;
    }

    /**
     * @return the idFormato
     */
    public Integer getIdFormato() {
        return idFormato;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the duracion
     */
    public Time getDuracion() {
        return duracion;
    }

    /**
     * @return the ventas
     */
    public Integer getVentas() {
        return ventas;
    }
    
    
    
}
