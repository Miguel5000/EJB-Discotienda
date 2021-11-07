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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Miguel
 */

@Entity
@Table(name = "compras_canciones", schema = "compras")
@NamedQueries({
    @NamedQuery(name = "CompraCancion.obtenerTodos", query = "SELECT c FROM CompraCancion c"),
    @NamedQuery(name = "CompraCancion.obtenerPorCompraYCancion", query = "SELECT coCa FROM CompraCancion coCa "
            + "JOIN Compra co "
            + "ON coCa.id_compra = co.id "
            + "JOIN Cancion ca "
            + "ON coCa.id_cancion = ca.id "
            + "WHERE co.id = :idCo AND ca.id = :idCa"),
    @NamedQuery(name = "CompraCancion.eliminarPorId" , query = "DELETE FROM CompraCancion c WHERE c.id = :id")
})

public class CompraCancion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    //Relaciones
    
    @NotNull(message = "La compra de la canción debe estar asociada a una compra")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra", nullable = false)
    private Compra compra;
    
    @NotNull(message = "La compra de la canción debe estar asociada a una canción")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cancion", nullable = false)
    private Cancion cancion;

    public CompraCancion() {
    }

    public CompraCancion(Integer id) {
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
     * @return the compra
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * @return the cancion
     */
    public Cancion getCancion() {
        return cancion;
    }

    /**
     * @param cancion the cancion to set
     */
    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }
    
    
    
}
