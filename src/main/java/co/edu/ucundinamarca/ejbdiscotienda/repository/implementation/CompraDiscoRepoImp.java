/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICompraDiscoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasDisco;
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
public class CompraDiscoRepoImp implements ICompraDiscoRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public CompraDisco obtenerPorCompraYDisco(Compra compra, Disco disco) {
        TypedQuery<CompraDisco> query = this.manager.createNamedQuery("CompraDisco.obtenerPorCompraYDisco", CompraDisco.class);
        query.setParameter("idCo", compra.getId());
        query.setParameter("idDis", disco.getId());
        return query.getSingleResult();
    }

    @Override
    public List<VentasDisco> obtenerVentas() {
        TypedQuery<VentasDisco> query = this.manager.createNamedQuery("VentasArtista.obtenerTodos", VentasDisco.class);
        return query.getResultList();
    }

    @Override
    public List<CompraDisco> obtenerTodos() {
        TypedQuery<CompraDisco> query = this.manager.createNamedQuery("CompraCancion.obtenerTodos", CompraDisco.class);
        return query.getResultList();
    }

    @Override
    public CompraDisco obtenerPorId(Integer id) {
        return this.manager.find(CompraDisco.class, id);
    }

    @Override
    public void crear(CompraDisco compraDisco) {
        this.manager.persist(compraDisco);
    }

    @Override
    public void editar(CompraDisco compraDisco) {
        CompraDisco compraDiscoOriginal = this.obtenerPorId(compraDisco.getId());
        compraDiscoOriginal.setCompra(compraDisco.getCompra());
        compraDiscoOriginal.setDisco(compraDisco.getDisco());
    }

    @Override
    public void eliminar(CompraDisco compraDisco) {
        this.manager.remove(compraDisco);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("CompraDisco.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }
    
}
