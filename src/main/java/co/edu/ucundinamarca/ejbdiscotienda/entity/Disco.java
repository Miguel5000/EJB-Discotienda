/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import java.io.Serializable;
import java.sql.Date;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Miguel
 */

@Entity
@Table(name = "discos", schema = "discos")
@NamedQueries({
    @NamedQuery(name = "Disco.obtenerTodos", query = "SELECT d FROM Disco d"),
    @NamedQuery(name = "Disco.obtenerListaPorCompra", query = "SELECT dis FROM Compra co "
            + "JOIN CompraDisco coDis "
            + "ON co.id = coDis.idCompra "
            + "JOIN Disco dis "
            + "ON coDis.idDisco = dis.id "
            + "WHERE co.id = :id"),
    @NamedQuery(name = "Disco.obtenerListaPorArtista", query = "SELECT dis FROM Artista ar "
            + "JOIN CreadorDisco creDis "
            + "ON ar.id = creDis.idArtista "
            + "JOIN Disco dis "
            + "ON creDis.idDisco = dis.id "
            + "WHERE ar.id = :id"),
    @NamedQuery(name = "Disco.obtenerListaDeCarrito", query = "SELECT dis FROM Compra co "
            + "JOIN CompraDisco coDis "
            + "ON co.id = coDis.idCompra "
            + "JOIN Disco dis "
            + "ON coDis.idDisco = dis.id "
            + "WHERE co.realizacion = false"),
    @NamedQuery(name = "Disco.obtenerPorNombreYArtista", query = "SELECT dis FROM Disco dis "
            + "JOIN CreadorDisco creDis "
            + "ON dis.id = creDis.idDisco "
            + "JOIN Artista ar "
            + "ON creDis.id_artista = ar.id "
            + "WHERE ar.id = :id AND dis.nombre = :nombre"),
    @NamedQuery(name = "Disco.eliminarPorId" , query = "DELETE FROM Disco d WHERE d.id = :id")
})

public class Disco implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "El disco debe tener un nombre")
    @Size(min = 1, max = 50, message = "El nombre no puede superar los 50 caracteres")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @NotNull(message = "El disco debe tener una fecha de lanzamiento")
    @Column(name = "fecha_de_lanzamiento", nullable = false)
    private Date fechaDeLanzamiento;
    
    @NotNull(message = "El disco debe tener un precio")
    @Min(value = 1, message = "El precio del disco debe ser mayor a 0")
    @Column(name = "precio", nullable = false)
    private Integer precio;
    
    @NotNull(message = "El disco debe tener una descripción")
    @Size(min = 1, message = "La descripción no puede estar vacía")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    //Relaciones
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraDisco> compras;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreadorDisco> creaciones;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancion> canciones;

    public Disco() {
    }

    public Disco(Integer id, String nombre, Date fechaDeLanzamiento, Integer precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.precio = precio;
        this.descripcion = descripcion;
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
     * @return the fechaDeLanzamiento
     */
    public Date getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    /**
     * @param fechaDeLanzamiento the fechaDeLanzamiento to set
     */
    public void setFechaDeLanzamiento(Date fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the compras
     */
    public List<CompraDisco> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<CompraDisco> compras) {
        this.compras = compras;
    }

    /**
     * @return the creaciones
     */
    public List<CreadorDisco> getCreaciones() {
        return creaciones;
    }

    /**
     * @param creaciones the creaciones to set
     */
    public void setCreaciones(List<CreadorDisco> creaciones) {
        this.creaciones = creaciones;
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
