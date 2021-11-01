/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Miguel
 */

@Entity
@Table(name = "compras", schema = "compras")
public class Compra implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "fecha_compra", nullable = true)
    private Date fechaCompra;
    
    @Min(value = 1, message = "El valor de la compra debe ser mayor a 0")
    @Column(name = "valor_compra", nullable = true)
    private Integer valorCompra;
    
    @NotNull(message = "La compra debe tener un estado de realización")
    @Column(name = "realizacion", nullable = false)
    private Boolean realizacion;

    public Compra() {
    }

    public Compra(Integer id, Date fechaCompra, Integer valorCompra, Boolean realizacion) {
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
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(Date fechaCompra) {
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
    
}
