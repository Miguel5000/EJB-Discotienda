/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraCancion;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICompraCancionRepo;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasCancion;
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
public class CompraCancionRepoImp implements ICompraCancionRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public CompraCancion obtenerPorCompraYCancion(Integer idCompra, Integer idCancion) {
        TypedQuery<CompraCancion> query = this.manager.createNamedQuery("CompraCancion.obtenerPorCompraYCancion", CompraCancion.class);
        query.setParameter("idCo", idCompra);
        query.setParameter("idCa", idCancion);
        return query.getResultList().isEmpty() ? null: query.getSingleResult();
    }

    @Override
    public List<VentasCancion> obtenerVentas() {
        TypedQuery<VentasCancion> query = this.manager.createNamedQuery("VentasCancion.obtenerTodos", VentasCancion.class);
        return query.getResultList();
    }

    @Override
    public List<CompraCancion> obtenerTodos() {
        TypedQuery<CompraCancion> query = this.manager.createNamedQuery("CompraCancion.obtenerTodos", CompraCancion.class);
        return query.getResultList();
    }

    @Override
    public CompraCancion obtenerPorId(Integer id) {
        return this.manager.find(CompraCancion.class, id);
    }

    @Override
    public void crear(CompraCancion compraCancion) {
        this.manager.persist(compraCancion);
    }

    @Override
    public void editar(CompraCancion compraCancion) {
        CompraCancion compraCancionOriginal = this.obtenerPorId(compraCancion.getId());
        compraCancionOriginal.setCancion(compraCancion.getCancion());
        compraCancionOriginal.setCompra(compraCancion.getCompra());
    }

    @Override
    public void eliminar(Integer id) {
        
        Query eliminacion = manager.createNamedQuery("CompraCancion.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
        
    }
    
    
    
}
