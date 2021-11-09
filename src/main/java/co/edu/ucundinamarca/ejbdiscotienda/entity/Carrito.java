/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CancionDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.DiscoDto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class Carrito implements Serializable{
    
    private List<CancionDto> canciones;
    private List<DiscoDto> discos;

    /**
     * @return the canciones
     */
    public List<CancionDto> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(List<CancionDto> canciones) {
        this.canciones = canciones;
    }

    /**
     * @return the discos
     */
    public List<DiscoDto> getDiscos() {
        return discos;
    }

    /**
     * @param discos the discos to set
     */
    public void setDiscos(List<DiscoDto> discos) {
        this.discos = discos;
    }
    
    
    
}
