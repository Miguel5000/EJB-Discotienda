/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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

/**
 *
 * @author Miguel
 */

@Entity
@Table(name = "compras", schema = "compras")
@NamedQueries({
    @NamedQuery(name = "Compra.obtenerTodos", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.obtenerCompraCarrito", query = "SELECT c FROM Compra c WHERE c.usuario.id = :id AND c.realizacion = false"),
    @NamedQuery(name = "Compra.obtenerComprasUsuario", query = "SELECT c FROM Compra c WHERE c.usuario.id = :id"),
    @NamedQuery(name = "Compra.eliminarPorId" , query = "DELETE FROM Compra c WHERE c.id = :id")
})

public class Compra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "fecha_compra", nullable = true)
    private Timestamp fechaCompra;
    
    @Min(value = 1, message = "El valor de la compra debe ser mayor a 0")
    @Column(name = "valor_compra", nullable = true)
    private Integer valorCompra;
    
    @NotNull(message = "La compra debe tener un estado de realización")
    @Column(name = "realizacion", nullable = false)
    private Boolean realizacion;
    
    //Relaciones
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraCancion> comprasCanciones;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraDisco> comprasDiscos;
    
    @NotNull(message = "La compra debe estar asociada a un usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Compra() {
    }

    public Compra(Integer id, Timestamp fechaCompra, Integer valorCompra, Boolean realizacion) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.valorCompra = valorCompra;
        this.realizacion = realizacion;
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
     * @return the fechaCompra
     */
    public Timestamp getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(Timestamp fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * @return the valorCompra
     */
    public Integer getValorCompra() {
        return valorCompra;
    }

    /**
     * @param valorCompra the valorCompra to set
     */
    public void setValorCompra(Integer valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * @return the realizacion
     */
    public Boolean getRealizacion() {
        return realizacion;
    }

    /**
     * @param realizacion the realizacion to set
     */
    public void setRealizacion(Boolean realizacion) {
        this.realizacion = realizacion;
    }

    /**
     * @return the comprasCanciones
     */
    public List<CompraCancion> getComprasCanciones() {
        return comprasCanciones;
    }

    /**
     * @param comprasCanciones the comprasCanciones to set
     */
    public void setComprasCanciones(List<CompraCancion> comprasCanciones) {
        this.comprasCanciones = comprasCanciones;
    }

    /**
     * @return the comprasDiscos
     */
    public List<CompraDisco> getComprasDiscos() {
        return comprasDiscos;
    }

    /**
     * @param comprasDiscos the comprasDiscos to set
     */
    public void setComprasDiscos(List<CompraDisco> comprasDiscos) {
        this.comprasDiscos = comprasDiscos;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
