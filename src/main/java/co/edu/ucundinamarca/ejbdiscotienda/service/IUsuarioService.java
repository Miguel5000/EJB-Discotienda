/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IUsuarioService {
 
    public List<Usuario> obtenerTodos();
    
    public Usuario obtenerPorId(Integer id);
    
    public void crear(Usuario usuario);
    
    public void editar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public void eliminarPorId(Integer id);
    
    public void enviarCorreoRecuperacion(String correo);
    
    public void recuperarClave(String token, String clave);
    
    public void enviarCorreoValidacion(String correo);
    
    public void modificarCorreo(String token);
    
}
