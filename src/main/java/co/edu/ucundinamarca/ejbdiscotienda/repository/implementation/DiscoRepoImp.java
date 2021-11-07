/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IDiscoRepo;
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
    public class DiscoRepoImp implements IDiscoRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<Disco> obtenerListaPorArtista(Artista artista) {
        TypedQuery<Disco> query = this.manager.createNamedQuery("Disco.obtenerListaPorArtista", Disco.class);
        query.setParameter("id", artista.getId());
        return query.getResultList();
    }

    @Override
    public List<Disco> obtenerListaPorCompra(Compra compra) {
        TypedQuery<Disco> query = this.manager.createNamedQuery("Disco.obtenerListaPorCompra", Disco.class);
        query.setParameter("id", compra.getId());
        return query.getResultList();
    }

    @Override
    public List<Disco> obtenerTodos() {
        TypedQuery<Disco> query = this.manager.createNamedQuery("Disco.obtenerTodos", Disco.class);
        return query.getResultList();
    }

    @Override
    public Disco obtenerPorId(Integer id) {
        return this.manager.find(Disco.class, id);
    }

    @Override
    public void crear(Disco disco) {
        this.manager.persist(disco);
    }

    @Override
    public void editar(Disco disco) {
        Disco discoOriginal = this.obtenerPorId(disco.getId());
        discoOriginal.setDescripcion(disco.getDescripcion());
        discoOriginal.setFechaDeLanzamiento(disco.getFechaDeLanzamiento());
        discoOriginal.setNombre(disco.getNombre());
        discoOriginal.setPrecio(disco.getPrecio());
    }

    @Override
    public void eliminar(Disco disco) {
        this.manager.remove(disco);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("Disco.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public Disco obtenerPorNombreYArtista(String nombre, Artista artista) {
        TypedQuery<Disco> query = this.manager.createNamedQuery("Disco.obtenerPorNombreYArtista", Disco.class);
        query.setParameter("id", artista.getId());
        query.setParameter("nombre", nombre);
        return query.getSingleResult();
    }
    
}
