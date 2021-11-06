/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto;

import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CompraDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.RolDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Rol;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class UsuarioDto {
 
    private Integer id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String clave;
    private String tokenRecuperacion;
    private String tokenCambioCorreo;
    private String nuevoCorreo;
    private List<CompraDto> compras;
    private RolDto rol;

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
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the tokenRecuperacion
     */
    public String getTokenRecuperacion() {
        return tokenRecuperacion;
    }

    /**
     * @param tokenRecuperacion the tokenRecuperacion to set
     */
    public void setTokenRecuperacion(String tokenRecuperacion) {
        this.tokenRecuperacion = tokenRecuperacion;
    }

    /**
     * @return the tokenCambioCorreo
     */
    public String getTokenCambioCorreo() {
        return tokenCambioCorreo;
    }

    /**
     * @param tokenCambioCorreo the tokenCambioCorreo to set
     */
    public void setTokenCambioCorreo(String tokenCambioCorreo) {
        this.tokenCambioCorreo = tokenCambioCorreo;
    }

    /**
     * @return the nuevoCorreo
     */
    public String getNuevoCorreo() {
        return nuevoCorreo;
    }

    /**
     * @param nuevoCorreo the nuevoCorreo to set
     */
    public void setNuevoCorreo(String nuevoCorreo) {
        this.nuevoCorreo = nuevoCorreo;
    }

    /**
     * @return the compras
     */
    public List<CompraDto> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<Compra> compras) {
        this.compras = CompraDtoManager.convertir(compras);
    }

    /**
     * @return the rol
     */
    public RolDto getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = RolDtoManager.convertir(rol);
    }
    
    
    
}
