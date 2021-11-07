/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CompraCancionDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CompraCancionDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraCancion;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICancionRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICompraCancionRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICompraRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.ICompraCancionService;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasCancion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class CompraCancionServiceImp implements ICompraCancionService{

    @EJB
    private ICompraCancionRepo repo;
    
    @EJB
    private ICompraRepo repoCompra;
    
    @EJB
    private ICancionRepo repoCancion;
    
    @Override
    public List<CompraCancionDto> obtenerTodos() throws ObtencionException {
        List<CompraCancion> comprasCanciones = this.repo.obtenerTodos();
        if(comprasCanciones == null || comprasCanciones.isEmpty())
            throw new ObtencionException("No hay compras de canciones disponibles");
        List<CompraCancionDto> comprasCancionesDto = CompraCancionDtoManager.convertir(comprasCanciones);
        return comprasCancionesDto;
    }

    @Override
    public CompraCancionDto obtenerPorId(Integer id) throws ObtencionException {
        CompraCancion compraCancion = this.repo.obtenerPorId(id);
        if(compraCancion == null)
            throw new ObtencionException("La compra de la canción no existe");
        CompraCancionDto compraCancionDto = CompraCancionDtoManager.convertir(compraCancion);
        return compraCancionDto;
    }

    @Override
    public void crear(CompraCancion compraCancion) throws CreacionException {
        //Validaciones
        if(compraCancion.getId() != null)
            throw new CreacionException("El id de la compra de la canción es autoincremental");
        
        //Compra
        Compra compra = compraCancion.getCompra();
        
        if(compra.getId() == null)
            throw new CreacionException("La creación de compras en la inserción de compras de canciones no está permitida");
        
        if(this.repoCompra.obtenerPorId(compra.getId()) == null)
            throw new CreacionException("No existe la compra con la que intenta vincular la compra de la canción");

        //Canción
        Cancion cancion = compraCancion.getCancion();
        
        if(cancion.getId() == null)
            throw new CreacionException("La creación de canciones en la inserción de compras de canciones no está permitida");
        
        if(this.repoCancion.obtenerPorId(cancion.getId()) == null)
            throw new CreacionException("No existe la canción con la que intenta vincular la compra de la canción");
        
        //Validaciones relaciones
        if(this.repo.obtenerPorCompraYCancion(compra, cancion) != null)
            throw new CreacionException("La canción no se puede registrar otra vez en la compra");
        
        this.repo.crear(compraCancion);
    }

    @Override
    public void editar(CompraCancion compraCancion) throws ObtencionException, EdicionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(CompraCancion compraCancion) throws ObtencionException {
        if(compraCancion.getId() == null || this.repo.obtenerPorId(compraCancion.getId()) == null)
            throw new ObtencionException("La compra de la canción a eliminar no existe");
        this.repo.eliminar(compraCancion);
    }

    @Override
    public void eliminarPorId(Integer id) throws ObtencionException {
        CompraCancion compraCancion = this.repo.obtenerPorId(id);
        if(compraCancion == null)
            throw new ObtencionException("La compra de la canción a eliminar no existe");
        this.repo.eliminarPorId(id);
    }

    @Override
    public void retirarCancion(Cancion cancion, Compra compra) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentasCancion> obtenerVentas() throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
