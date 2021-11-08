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
import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
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
    public Carrito obtenerCarrito(Usuario usuario) {
        TypedQuery<Disco> queryD = this.manager.createNamedQuery("Disco.obtenerListaDeCarrito", Disco.class);
        List<Disco> discos = queryD.getResultList();
        
        TypedQuery<Cancion> queryC = this.manager.createNamedQuery("Cancion.obtenerListaDeCarrito", Cancion.class);
        List<Cancion> canciones = queryC.getResultList();
        
        Carrito carrito = new Carrito();
        carrito.setCanciones(CancionDtoManager.convertir(canciones));
        carrito.setDiscos(DiscoDtoManager.convertir(discos));
        
        return carrito;
    }
    
    @Override
    public Compra obtenerCompraCarrito(Usuario usuario) {
        TypedQuery<Compra> query = this.manager.createNamedQuery("CompraCancion.obtenerCompraCarrito", Compra.class);
        query.setParameter("id", usuario.getId());
        return query.getSingleResult();
    }

    @Override
    public List<Compra> obtenerTodos() {
        TypedQuery<Compra> query = this.manager.createNamedQuery("CompraCancion.obtenerTodos", Compra.class);
        
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
    public void eliminar(Compra compra) {
        this.manager.persist(compra);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("Compra.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }
    
}
