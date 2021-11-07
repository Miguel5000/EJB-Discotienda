/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Genero;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IGeneroRepo;
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
public class GeneroRepoImp implements IGeneroRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<Genero> obtenerTodos() {
        TypedQuery<Genero> query = this.manager.createNamedQuery("Genero.obtenerTodos", Genero.class);
        return query.getResultList();
    }

    @Override
    public Genero obtenerPorId(Integer id) {
        return this.manager.find(Genero.class, id);
    }

    @Override
    public void crear(Genero genero) {
        this.manager.persist(genero);
    }

    @Override
    public void editar(Genero genero) {
        Genero generoOriginal = this.obtenerPorId(genero.getId());
        generoOriginal.setNombre(genero.getNombre());
    }

    @Override
    public void eliminar(Genero genero) {
        this.manager.remove(genero);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("Genero.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public Genero obtenerPorNombre(String nombre) {
        TypedQuery<Genero> query = this.manager.createNamedQuery("Genero.obtenerPorNombre", Genero.class);
        query.setParameter("nombre", nombre);
        return query.getSingleResult();
    }
    
}
