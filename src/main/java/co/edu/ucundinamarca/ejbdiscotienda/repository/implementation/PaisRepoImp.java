/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Pais;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IPaisRepo;
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
public class PaisRepoImp implements IPaisRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<Pais> obtenerTodos() {
        TypedQuery<Pais> query = this.manager.createNamedQuery("Pais.obtenerTodos", Pais.class);
        return query.getResultList();
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        return this.manager.find(Pais.class, id);
    }

    @Override
    public void crear(Pais pais) {
        this.manager.persist(pais);
    }

    @Override
    public void editar(Pais pais) {
        Pais paisOriginal = this.obtenerPorId(pais.getId());
        paisOriginal.setNombre(pais.getNombre());
    }

    @Override
    public void eliminar(Integer id) {
        Query eliminacion = manager.createNamedQuery("Pais.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public Pais obtenerPorNombre(String nombre) {
        TypedQuery<Pais> query = this.manager.createNamedQuery("Pais.obtenerPorNombre", Pais.class);
        query.setParameter("nombre", nombre);
        return query.getResultList().isEmpty() ? null: query.getSingleResult();
    }
    
}
