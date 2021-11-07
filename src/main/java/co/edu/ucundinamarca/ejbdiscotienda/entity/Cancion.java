/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import java.sql.Time;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "canciones", schema = "canciones")
@NamedQueries({
    @NamedQuery(name = "Cancion.obtenerTodos", query = "SELECT c FROM Cancion c"),
    @NamedQuery(name = "Cancion.obtenerListaPorCompra", query = "SELECT ca FROM Compra co "
            + "JOIN CompraCancion coCa "
            + "ON co.id = coCa.idCompra "
            + "JOIN Cancion ca "
            + "ON coCa.idCancion = ca.id "
            + "WHERE co.id = :id"),
    @NamedQuery(name = "Cancion.obtenerListaDeCarrito", query = "SELECT ca FROM Compra co "
            + "JOIN CompraCancion coCa "
            + "ON co.id = coCa.idCompra "
            + "JOIN Cancion ca "
            + "ON coCa.idCancion = ca.id "
            + "WHERE co.realizacion = false"),
    @NamedQuery(name = "Cancion.obtenerPorNombreYDisco", query = "SELECT ca FROM Cancion ca "
            + "JOIN Disco dis "
            + "ON ca.idDisco = dis.id "
            + "WHERE dis.id = :id AND ca.nombre = :nombre"),
    @NamedQuery(name = "Cancion.eliminarPorId" , query = "DELETE FROM Cancion c WHERE c.id = :id")
})

public class Cancion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "La canción debe tener un nombre")
    @Size(min = 1, max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @NotNull(message = "La canción debe tener un precio")
    @Min(value = 1, message = "El precio del disco debe ser mayor a 0")
    @Column(name = "precio", nullable = false)
    private Integer precio;
    
    @NotNull(message = "La canción debe tener una descripción")
    @Size(min = 1, message = "La descripción no puede estar vacía")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @NotNull(message = "La canción debe tener una duración")
    @Column(name = "duracion", nullable = false)
    private Time duracion;
    
    //Relaciones
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cancion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraCancion> compras;
    
    @NotNull(message = "La canción debe tener un formato")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formato", nullable = false)
    private Formato formato;
    
    @NotNull(message = "La canción debe tener un disco del que proviene")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disco", nullable = false)
    private Disco disco;

    public Cancion() {
    }

    public Cancion(Integer id, String nombre, Integer precio, String descripcion, Time duracion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.duracion = duracion;
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
     * @return the duracion
     */
    public Time getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the compras
     */
    public List<CompraCancion> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<CompraCancion> compras) {
        this.compras = compras;
    }

    /**
     * @return the formato
     */
    public Formato getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(Formato formato) {
        this.formato = formato;
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
