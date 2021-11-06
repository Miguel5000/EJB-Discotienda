/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto;

import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CancionDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CompraDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;

/**
 *
 * @author Miguel
 */
public class CompraCancionDto {
    
    private Integer id;
    private CompraDto compra;
    private CancionDto cancion;

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
    public CompraDto getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(Compra compra) {
        this.compra = CompraDtoManager.convertir(compra);
    }

    /**
     * @return the cancion
     */
    public CancionDto getCancion() {
        return cancion;
    }

    /**
     * @param cancion the cancion to set
     */
    public void setCancion(Cancion cancion) {
        this.cancion = CancionDtoManager.convertir(cancion);
    }
    
    
    
}
