/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Miguel
 */

@Entity
@Table(name = "usuarios", schema = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuario.obtenerTodos", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.obtenerPorLogin" , query = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.clave = :clave"),
    @NamedQuery(name = "Usuario.obtenerPorTokenRecuperacion" , query = "SELECT u FROM Usuario u WHERE u.tokenRecuperacion = :tokenRecuperacion"),
    @NamedQuery(name = "Usuario.obtenerPorTokenCorreo" , query = "SELECT u FROM Usuario u WHERE u.tokenCambioCorreo = :tokenCambioCorreo"),
    @NamedQuery(name = "Usuario.obtenerPorCorreo" , query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.obtenerPorNuevoCorreo" , query = "SELECT u FROM Usuario u WHERE u.nuevoCorreo = :correo"),
    @NamedQuery(name = "Usuario.obtenerPorLogin" , query = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.clave = :clave"),
    @NamedQuery(name = "Usuario.eliminarPorId" , query = "DELETE FROM Usuario u WHERE u.id = :id")
        
})

public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "El usuario debe tener un nombre")
    @Size(min = 1, max = 15, message = "Los nombres no pueden superar en conjunto los 15 caracteres")
    @Column(name = "nombres", nullable = false, length = 15)
    private String nombres;
    
    @NotNull(message = "El usuario debe tener un apellido")
    @Size(min = 1, max = 15, message = "Los apellidos no pueden superar en conjunto los 15 caracteres")
    @Column(name = "apellidos", nullable = false, length = 15)
    private String apellidos;
    
    @NotNull(message = "El usuario debe tener un correo")
    @Size(min = 1, max = 50, message = "El correo no puede superar los 50 caracteres")
    @Column(name = "correo", nullable = false, length = 50, unique = true)
    private String correo;
    
    @NotNull(message = "El usuario debe tener una contraseña")
    @Size(min = 1, max = 15, message = "La contraseña no puede superar los 15 caracteres")
    @Column(name = "clave", nullable = false, length = 15)
    private String clave;
    
    @Size(min = 1, max = 200, message = "El token de recuperación no puede superar los 200 caracteres")
    @Column(name = "token_recuperacion", nullable = true, length = 200, unique = true)
    private String tokenRecuperacion;
    
    @Size(min = 1, max = 200, message = "El token de cambio de correo no puede superar los 200 caracteres")
    @Column(name = "token_cambio_correo", nullable = true, length = 200, unique = true)
    private String tokenCambioCorreo;
    
    @Size(min = 1, max = 50, message = "El nuevo correo no puede superar los 50 caracteres")
    @Column(name = "nuevo_correo", nullable = true, length = 50, unique = true)
    private String nuevoCorreo;
    
    //Relaciones
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compra> compras;
    
    @NotNull(message = "El usuario debe poseer un rol")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    public Usuario(){}
    
    public Usuario(Integer id, String nombres, String apellidos, String correo, String clave, String tokenRecuperacion, String tokenCambioCorreo, String nuevoCorreo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.clave = clave;
        this.tokenRecuperacion = tokenRecuperacion;
        this.tokenCambioCorreo = tokenCambioCorreo;
        this.nuevoCorreo = nuevoCorreo;
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
    public List<Compra> getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    
}
