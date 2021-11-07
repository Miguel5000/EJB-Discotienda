/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.view;

import java.sql.Date;
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
@Table(name = "ventas_discos", schema = "compras")
@NamedQueries({
    @NamedQuery(name = "VentasDisco.obtenerTodos", query = "SELECT v FROM VentasDisco v"),
})

public class VentasDisco {
 
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "fecha_de_lanzamiento")
    private Date fechaDeLanzamiento;
    
    @Column(name = "precio")
    private String precio;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "ventas")
    private Integer ventas;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the fechaDeLanzamiento
     */
    public Date getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the ventas
     */
    public Integer getVentas() {
        return ventas;
    }
    
}
