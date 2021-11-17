/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.UsuarioDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.UsuarioDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Rol;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IRolRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IUsuarioRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.IUsuarioService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class UsuarioServiceImp implements IUsuarioService{

    @EJB
    private IUsuarioRepo repo;
    
    @EJB
    private IRolRepo repoRol;
    
    @Override
    public List<UsuarioDto> obtenerTodos() throws ObtencionException {
        List<Usuario> usuarios = this.repo.obtenerTodos();
        if(usuarios == null || usuarios.isEmpty())
            throw new ObtencionException("No hay usuarios disponibles");
        List<UsuarioDto> usuariosDto = UsuarioDtoManager.convertir(usuarios);
        return usuariosDto;
    }

    @Override
    public UsuarioDto obtenerPorId(Integer id) throws ObtencionException {
        Usuario usuario = this.repo.obtenerPorId(id);
        if(usuario == null)
            throw new ObtencionException("El usuario no existe");
        UsuarioDto usuarioDto = UsuarioDtoManager.convertir(usuario);
        return usuarioDto;
    }

    @Override
    public void crear(Usuario usuario) throws CreacionException {
        //Validaciones
        if(usuario.getId() != null)
            throw new CreacionException("El id del usuario es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(usuario.getCompras() != null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        //Rol
        Rol rol = usuario.getRol();
        
        if(rol.getId() == null)
            throw new CreacionException("La creación de roles en la inserción de usuarios no está permitida");
        
        if(this.repoRol.obtenerPorId(rol.getId()) == null)
            throw new CreacionException("No existe el rol con el que intenta vincular al usuario");

        //Validaciones unicidad
        if(this.repo.obtenerPorCorreo(usuario.getCorreo()) != null)
            throw new CreacionException("Ya existe un usuario con ese correo");
        
        if(usuario.getNuevoCorreo() != null && this.repo.obtenerPorNuevoCorreo(usuario.getNuevoCorreo()) != null)
            throw new CreacionException("Ya existe un usuario con ese nuevo correo");
        
        if(usuario.getTokenRecuperacion() != null && this.repo.obtenerPorTokenDeRecuperacion(usuario.getTokenRecuperacion()) != null)
            throw new CreacionException("Ya existe un usuario con ese token de recuperacion");
        
        if(usuario.getTokenCambioCorreo()!= null && this.repo.obtenerPorTokenDeNuevoCorreo(usuario.getTokenCambioCorreo()) != null)
            throw new CreacionException("Ya existe un usuario con ese token de cambio de correo");
        
        this.repo.crear(usuario);
    }

    @Override
    public void editar(Usuario usuario) throws ObtencionException, EdicionException {
        if(usuario.getId() == null || this.repo.obtenerPorId(usuario.getId()) == null)
            throw new ObtencionException("El usuario a editar no existe");
        
        //Rol
        Rol rol = usuario.getRol();
        
        if(rol.getId() == null)
            throw new EdicionException("El rol debe tener un id");
        
        if(this.repoRol.obtenerPorId(rol.getId()) == null)
            throw new EdicionException("No existe el rol con el que intenta vincular al usuario");

        //Validaciones unicidad
        Usuario usuarioPorCorreo = this.repo.obtenerPorCorreo(usuario.getCorreo());
        
        if(usuarioPorCorreo != null && usuarioPorCorreo.getId().intValue() != usuario.getId().intValue())
            throw new EdicionException("Ya existe un usuario con ese correo");
        
        Usuario usuarioPorNuevoCorreo = this.repo.obtenerPorNuevoCorreo(usuario.getNuevoCorreo());
        
        if(usuario.getNuevoCorreo() != null && usuarioPorNuevoCorreo != null && usuarioPorNuevoCorreo.getId().intValue() != usuario.getId().intValue())
            throw new EdicionException("Ya existe un usuario con ese nuevo correo");
        
        Usuario usuarioPorTokenRecupercion = this.repo.obtenerPorTokenDeRecuperacion(usuario.getTokenRecuperacion());
        
        if(usuario.getTokenRecuperacion() != null && usuarioPorTokenRecupercion != null && usuarioPorTokenRecupercion.getId().intValue() != usuario.getId().intValue())
            throw new EdicionException("Ya existe un usuario con ese token de recuperacion");
        
        Usuario usuarioPorTokenCambioCorreo = this.repo.obtenerPorTokenDeNuevoCorreo(usuario.getTokenCambioCorreo());
        
        if(usuario.getTokenCambioCorreo()!= null && usuarioPorTokenCambioCorreo != null && usuarioPorTokenCambioCorreo.getId().intValue() != usuario.getId().intValue())
            throw new EdicionException("Ya existe un usuario con ese token de cambio de correo");
        
        this.repo.editar(usuario);
    }

    @Override
    public void eliminar(Integer id) throws ObtencionException {
        Usuario usuario = this.repo.obtenerPorId(id);
        if(usuario == null)
            throw new ObtencionException("El usuario a eliminar no existe");
        this.repo.eliminar(id);
    }
    
    @Override
    public UsuarioDto iniciarSesion(String correo, String clave) throws ObtencionException {
        Usuario usuario = this.repo.obtenerPorLogin(correo, clave);
        if(usuario == null)
            throw new ObtencionException("El usuario no existe");
        UsuarioDto usuarioDto = UsuarioDtoManager.convertir(usuario);
        return usuarioDto;
    }

    @Override
    public void enviarCorreoRecuperacion(String correo) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recuperarClave(String token, String clave) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarCorreoValidacion(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarCorreo(String token) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
