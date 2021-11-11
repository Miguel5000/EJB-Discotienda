/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CancionDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.DiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Carrito;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICompraRepo;
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
public class CompraRepoImp implements ICompraRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public Carrito obtenerCarrito(Integer id) {
        TypedQuery<Disco> queryD = this.manager.createNamedQuery("Disco.obtenerListaDeCarrito", Disco.class);
        queryD.setParameter("id", id);
        List<Disco> discos = queryD.getResultList();
        
        TypedQuery<Cancion> queryC = this.manager.createNamedQuery("Cancion.obtenerListaDeCarrito", Cancion.class);
        queryC.setParameter("id", id);
        List<Cancion> canciones = queryC.getResultList();
        
        if((discos == null || discos.isEmpty()) && (canciones == null || canciones.isEmpty()))
            return null;
        
        Carrito carrito = new Carrito();
        carrito.setCanciones(CancionDtoManager.convertir(canciones));
        carrito.setDiscos(DiscoDtoManager.convertir(discos));
        
        return carrito;
    }
    
    @Override
    public Compra obtenerCompraCarrito(Integer id) {
        TypedQuery<Compra> query = this.manager.createNamedQuery("Compra.obtenerCompraCarrito", Compra.class);
        query.setParameter("id", id);
        return query.getResultList().isEmpty() ? null: query.getSingleResult();
    }

    @Override
    public List<Compra> obtenerTodos() {
        TypedQuery<Compra> query = this.manager.createNamedQuery("Compra.obtenerTodos", Compra.class);
        
        return query.getResultList();
    }

    @Override
    public Compra obtenerPorId(Integer id) {
        return this.manager.find(Compra.class, id);
    }

    @Override
    public void crear(Compra compra) {
        this.manager.persist(compra);
    }

    @Override
    public void editar(Compra compra) {
        Compra compraOriginal = this.obtenerPorId(compra.getId());
        compraOriginal.setFechaCompra(compra.getFechaCompra());
        compraOriginal.setRealizacion(compra.getRealizacion());
        compraOriginal.setUsuario(compra.getUsuario());
        compraOriginal.setValorCompra(compra.getValorCompra());
    }

    @Override
    public void eliminar(Integer id) {
        Query eliminacion = manager.createNamedQuery("Compra.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }
    
}
