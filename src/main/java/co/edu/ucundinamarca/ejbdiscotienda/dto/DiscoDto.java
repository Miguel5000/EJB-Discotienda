/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto;

import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CancionDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CompraDiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CreadorDiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CreadorDisco;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class DiscoDto {
    
    private Integer id;
    private String nombre;
    private Date fechaDeLanzamiento;
    private Integer precio;
    private String descripcion;
    private List<CompraDiscoDto> compras;
    private List<CreadorDiscoDto> creaciones;
    private List<CancionDto> canciones;
    private String portada;
    private Byte[] portadaEnBytes;

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
    public List<CompraDiscoDto> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<CompraDisco> compras) {
        this.compras = CompraDiscoDtoManager.convertir(compras);
    }

    /**
     * @return the creaciones
     */
    public List<CreadorDiscoDto> getCreaciones() {
        return creaciones;
    }

    /**
     * @param creaciones the creaciones to set
     */
    public void setCreaciones(List<CreadorDisco> creaciones) {
        this.creaciones = CreadorDiscoDtoManager.convertir(creaciones);
    }

    /**
     * @return the canciones
     */
    public List<CancionDto> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = CancionDtoManager.convertir(canciones);
    }

    /**
     * @return the portada
     */
    public String getPortada() {
        return portada;
    }

    /**
     * @param portada the portada to set
     */
    public void setPortada(String portada) {
        this.portada = portada;
    }

    /**
     * @return the portadaEnBytes
     */
    public Byte[] getPortadaEnBytes() {
        return portadaEnBytes;
    }

    /**
     * @param portadaEnBytes the portadaEnBytes to set
     */
    public void setPortadaEnBytes(Byte[] portadaEnBytes) {
        this.portadaEnBytes = portadaEnBytes;
    }

}
