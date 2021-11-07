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
@Table(name = "compras_discos", schema = "compras")
@NamedQueries({
    @NamedQuery(name = "CompraDisco.obtenerTodos", query = "SELECT c FROM CompraDisco c"),
    @NamedQuery(name = "CompraDisco.obtenerPorCompraYDisco", query = "SELECT coDis FROM CompraDisco coDis "
            + "JOIN Compra co "
            + "ON coDis.id_compra = co.id "
            + "JOIN Disco dis "
            + "ON coCa.id_disco = dis.id "
            + "WHERE co.id = :idCo AND dis.id = :idDis"),
    @NamedQuery(name = "CompraDisco.eliminarPorId" , query = "DELETE FROM CompraDisco c WHERE c.id = :id")
})

public class CompraDisco implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    //Relaciones
    
    @NotNull(message = "La compra del disco debe estar asociada a una compra")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_compra", nullable = false)
    private Compra compra;
    
    @NotNull(message = "La compra del disco debe tener un disco asociado")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disco", nullable = false)
    private Disco disco;

    public CompraDisco() {
    }

    public CompraDisco(Integer id) {
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
