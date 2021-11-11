/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CreadorDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICreadorDiscoRepo;
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
public class CreadorDiscoRepoImp implements ICreadorDiscoRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<CreadorDisco> obtenerTodos() {
        TypedQuery<CreadorDisco> query = this.manager.createNamedQuery("CreadorDisco.obtenerTodos", CreadorDisco.class);
        return query.getResultList();
    }

    @Override
    public CreadorDisco obtenerPorId(Integer id) {
        return this.manager.find(CreadorDisco.class, id);
    }

    @Override
    public void crear(CreadorDisco creadorDisco) {
        this.manager.persist(creadorDisco);
    }

    @Override
    public void editar(CreadorDisco creadorDisco) {
        CreadorDisco creadorDiscoOriginal = this.obtenerPorId(creadorDisco.getId());
        creadorDiscoOriginal.setArtista(creadorDisco.getArtista());
        creadorDiscoOriginal.setDisco(creadorDisco.getDisco());
    }

    @Override
    public void eliminar(Integer id) {
        Query eliminacion = manager.createNamedQuery("CreadorDisco.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public CreadorDisco obtenerPorCreadorYDisco(Artista artista, Disco disco) {
        TypedQuery<CreadorDisco> query = this.manager.createNamedQuery("CreadorDisco.obtenerPorCreadorYDisco", CreadorDisco.class);
        query.setParameter("idArtista", artista.getId());
        query.setParameter("idDisco", disco.getId());
        return query.getResultList().isEmpty() ? null: query.getSingleResult();
    }
    
}
