/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto;

import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.DiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.FormatoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Formato;
import java.sql.Time;

/**
 *
 * @author Miguel
 */
public class CancionDto {
 
    private Integer id;
    private String nombre;
    private Integer precio;
    private String descripcion;
    private Time duracion;
    private FormatoDto formato;
    private DiscoDto disco;

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
     * @return the formato
     */
    public FormatoDto getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(Formato formato) {
        this.formato = FormatoDtoManager.convertir(formato);
    }

    /**
     * @return the disco
     */
    public DiscoDto getDisco() {
        return disco;
    }

    /**
     * @param disco the disco to set
     */
    public void setDisco(Disco disco) {
        this.disco = DiscoDtoManager.convertir(disco);
    }
    
    
    
}
