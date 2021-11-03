/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.view;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author Miguel
 */

@Table(name = "ventas_artistas", schema = "compras")
public class VentasArtista {
    
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "id_genero")
    private Integer idGenero;
    
    @Column(name = "idPais")
    private Integer idPais;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "nombre_artistico")
    private String nombreArtistico;
    
    @Column(name = "fecha_de_nacimiento")
    private Date fechaDeNacimiento;
    
    @Column(name = "foto")
    private String foto;
    
    @Column(name = "ventas_discos")
    private Integer ventasDiscos;
    
    @Column(name = "ventas_canciones")
    private Integer ventasCanciones;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the idGenero
     */
    public Integer getIdGenero() {
        return idGenero;
    }

    /**
     * @return the idPais
     */
    public Integer getIdPais() {
        return idPais;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @return the nombreArtistico
     */
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    /**
     * @return the fechaDeNacimiento
     */
    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @return the ventasDiscos
     */
    public Integer getVentasDiscos() {
        return ventasDiscos;
    }

    /**
     * @return the ventasCanciones
     */
    public Integer getVentasCanciones() {
        return ventasCanciones;
    }
    
}
