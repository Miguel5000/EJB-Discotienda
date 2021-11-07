/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Formato;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IFormatoRepo;
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
public class FormatoRepoImp implements IFormatoRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<Formato> obtenerTodos() {
        TypedQuery<Formato> query = this.manager.createNamedQuery("Formato.obtenerTodos", Formato.class);
        return query.getResultList();
    }

    @Override
    public Formato obtenerPorId(Integer id) {
        return this.manager.find(Formato.class, id);
    }

    @Override
    public void crear(Formato formato) {
        this.manager.persist(formato);
    }

    @Override
    public void editar(Formato formato) {
        Formato formatoOriginal = this.obtenerPorId(formato.getId());
        formatoOriginal.setNombre(formato.getNombre());
    }

    @Override
    public void eliminar(Formato formato) {
        this.manager.remove(formato);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("Formato.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public Formato obtenerPorNombre(String nombre) {
        TypedQuery<Formato> query = this.manager.createNamedQuery("Formato.obtenerPorNombre", Formato.class);
        query.setParameter("nombre", nombre);
        return query.getSingleResult();
    }
    
}
