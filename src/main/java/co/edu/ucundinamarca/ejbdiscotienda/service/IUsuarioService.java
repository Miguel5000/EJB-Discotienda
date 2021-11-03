/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IUsuarioService {
 
    public List<Usuario> obtenerTodos() throws ObtencionException;
    
    public Usuario obtenerPorId(Integer id) throws ObtencionException;
    
    public void crear(Usuario usuario) throws CreacionException;
    
    public void editar(Usuario usuario) throws ObtencionException, EdicionException;
    
    public void eliminar(Usuario usuario) throws ObtencionException;
    
    public void eliminarPorId(Integer id) throws ObtencionException;
    
    public void enviarCorreoRecuperacion(String correo) throws ObtencionException;
    
    public void recuperarClave(String token, String clave) throws ObtencionException;
    
    public void enviarCorreoValidacion(String correo);
    
    public void modificarCorreo(String token) throws ObtencionException;
    
}
