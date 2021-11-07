/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICancionRepo;
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
public class CancionRepoImp implements ICancionRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<Cancion> obtenerListaPorCompra(Compra compra) {
        TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.obtenerListaPorCompra", Cancion.class);
        query.setParameter("id", compra.getId());
        return query.getResultList();
    }

    @Override
    public List<Cancion> obtenerListaPorDisco(Disco disco) {
        Disco discoOriginal = new DiscoRepoImp().obtenerPorId(disco.getId());
        return discoOriginal.getCanciones();
    }

    @Override
    public List<Cancion> obtenerTodos() {
        TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.obtenerTodos", Cancion.class);
        return query.getResultList();
    }

    @Override
    public Cancion obtenerPorId(Integer id) {
        return this.manager.find(Cancion.class, id);
    }

    @Override
    public void crear(Cancion cancion) {
        this.manager.persist(cancion);
    }

    @Override
    public void editar(Cancion cancion) {
        Cancion cancionOriginal = this.obtenerPorId(cancion.getId());
        cancionOriginal.setDescripcion(cancion.getDescripcion());
        cancionOriginal.setDisco(cancion.getDisco());
        cancionOriginal.setDuracion(cancion.getDuracion());
        cancionOriginal.setFormato(cancion.getFormato());
        cancionOriginal.setNombre(cancion.getNombre());
        cancionOriginal.setPrecio(cancion.getPrecio());
    }

    @Override
    public void eliminar(Cancion cancion) {
        this.manager.remove(cancion);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("Cancion.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public Cancion obtenerPorNombreYDisco(String nombre, Disco disco) {
        TypedQuery<Cancion> query = this.manager.createNamedQuery("Cancion.obtenerPorNombreYDisco", Cancion.class);
        query.setParameter("id", disco.getId());
        query.setParameter("nombre", disco.getNombre());
        return query.getSingleResult();
    }
    
}
