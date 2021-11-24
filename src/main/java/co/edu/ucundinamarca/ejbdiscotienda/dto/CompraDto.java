/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto;

import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CompraCancionDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CompraDiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.UsuarioDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraCancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class CompraDto {
    
    private Integer id;
    private Timestamp fechaCompra;
    private Integer valorCompra;
    private Boolean realizacion;
    private List<CompraCancionDto> comprasCanciones;
    private List<CompraDiscoDto> comprasDiscos;
    private UsuarioDto usuario;

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
    public List<CompraCancionDto> getComprasCanciones() {
        return comprasCanciones;
    }

    /**
     * @param comprasCanciones the comprasCanciones to set
     */
    public void setComprasCanciones(List<CompraCancion> comprasCanciones) {
        this.comprasCanciones = CompraCancionDtoManager.convertir(comprasCanciones);
    }

    /**
     * @return the comprasDiscos
     */
    public List<CompraDiscoDto> getComprasDiscos() {
        return comprasDiscos;
    }

    /**
     * @param comprasDiscos the comprasDiscos to set
     */
    public void setComprasDiscos(List<CompraDisco> comprasDiscos) {
        this.comprasDiscos = CompraDiscoDtoManager.convertir(comprasDiscos);
    }

    /**
     * @return the usuario
     */
    public UsuarioDto getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = UsuarioDtoManager.convertir(usuario);
    }
    
    
    
}
