/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Miguel
 */

@Local
public interface IUsuarioRepo extends ICrud<Usuario, Integer>{
    
    public Usuario obtenerPorInicioDeSesion(String usuario, String clave);
    
    public Usuario obtenerPorTokenDeRecuperacion(String token);
    
    public Usuario obtenerPorTokenDeNuevoCorreo(String token);
    
}
