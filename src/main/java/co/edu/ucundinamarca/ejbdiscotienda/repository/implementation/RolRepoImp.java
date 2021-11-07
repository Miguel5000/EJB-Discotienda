/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Rol;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IRolRepo;
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
public class RolRepoImp implements IRolRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<Rol> obtenerTodos() {
        TypedQuery<Rol> query = this.manager.createNamedQuery("Rol.obtenerTodos", Rol.class);
        return query.getResultList();
    }

    @Override
    public Rol obtenerPorId(Integer id) {
        return this.manager.find(Rol.class, id);
    }

    @Override
    public void crear(Rol rol) {
        this.manager.persist(rol);
    }

    @Override
    public void editar(Rol rol) {
        Rol rolOriginal = this.obtenerPorId(rol.getId());
        rolOriginal.setNombre(rol.getNombre());
    }

    @Override
    public void eliminar(Rol rol) {
        this.manager.remove(rol);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("Rol.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public Rol obtenerPorNombre(String nombre) {
        TypedQuery<Rol> query = this.manager.createNamedQuery("Rol.obtenerPorNombre", Rol.class);
        query.setParameter("nombre", nombre);
        return query.getSingleResult();
    }
    
}
