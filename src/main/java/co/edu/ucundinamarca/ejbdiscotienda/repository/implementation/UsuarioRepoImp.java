/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IUsuarioRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Miguel
 */

@Stateless
public class UsuarioRepoImp implements IUsuarioRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public Usuario obtenerPorInicioDeSesion(String correo, String clave) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.obtenerPorLogin", Usuario.class);
        query.setParameter("correo", correo);
        query.setParameter("clave", clave);
        return query.getSingleResult();
    }

    @Override
    public Usuario obtenerPorTokenDeRecuperacion(String token) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.obtenerPorTokenRecuperacion", Usuario.class);
        query.setParameter("tokenRecuperacion", token);
        return query.getSingleResult();
    }

    @Override
    public Usuario obtenerPorTokenDeNuevoCorreo(String token) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.obtenerPorTokenCambioCorreo", Usuario.class);
        query.setParameter("tokenCambioCorreo", token);
        return query.getSingleResult();
    }

    @Override
    public List<Usuario> obtenerTodos() {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.obtenerTodos", Usuario.class);
        return query.getResultList();
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return this.manager.find(Usuario.class, id);
    }

    @Override
    public void crear(Usuario usuario) {
        this.manager.persist(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        Usuario usuarioOriginal = this.obtenerPorId(usuario.getId());
        usuarioOriginal.setApellidos(usuario.getApellidos());
        usuarioOriginal.setClave(usuario.getClave());
        usuarioOriginal.setCorreo(usuario.getCorreo());
        usuarioOriginal.setNombres(usuario.getNombres());
        usuarioOriginal.setNuevoCorreo(usuario.getNuevoCorreo());
        usuarioOriginal.setRol(usuario.getRol());
        usuarioOriginal.setTokenCambioCorreo(usuario.getTokenCambioCorreo());
        usuarioOriginal.setTokenRecuperacion(usuario.getTokenRecuperacion());
    }

    @Override
    public void eliminar(Usuario usuario) {
        this.manager.remove(usuario);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("Usuario.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public Usuario obtenerPorCorreo(String correo) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.obtenerPorCorreo", Usuario.class);
        query.setParameter("correo", correo);
        return query.getSingleResult();
    }

    @Override
    public Usuario obtenerPorNuevoCorreo(String correo) {
        TypedQuery<Usuario> query = this.manager.createNamedQuery("Usuario.obtenerPorNuevoCorreo", Usuario.class);
        query.setParameter("correo", correo);
        return query.getSingleResult();
    }
    
}
