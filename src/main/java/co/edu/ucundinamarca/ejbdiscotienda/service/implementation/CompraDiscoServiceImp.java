/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CompraDiscoDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CompraDiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICompraDiscoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICompraRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IDiscoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasDisco;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class CompraDiscoServiceImp implements co.edu.ucundinamarca.ejbdiscotienda.service.ICompraDiscoService{

    @EJB
    private ICompraDiscoRepo repo;
    
    @EJB
    private ICompraRepo repoCompra;
    
    @EJB
    private IDiscoRepo repoDisco;
    
    @Override
    public List<CompraDiscoDto> obtenerTodos() throws ObtencionException {
        List<CompraDisco> comprasDiscos = this.repo.obtenerTodos();
        if(comprasDiscos == null || comprasDiscos.isEmpty())
            throw new ObtencionException("No hay compras de discos disponibles");
        List<CompraDiscoDto> comprasDiscosDto = CompraDiscoDtoManager.convertir(comprasDiscos);
        return comprasDiscosDto;
    }

    @Override
    public CompraDiscoDto obtenerPorId(Integer id) throws ObtencionException {
        CompraDisco compraDisco = this.repo.obtenerPorId(id);
        if(compraDisco == null)
            throw new ObtencionException("La compra del disco no existe");
        CompraDiscoDto compraDiscoDto = CompraDiscoDtoManager.convertir(compraDisco);
        return compraDiscoDto;
    }

    @Override
    public void crear(CompraDisco compraDisco) throws CreacionException {
        //Validaciones
        if(compraDisco.getId() != null)
            throw new CreacionException("El id de la compra del disco es autoincremental");
        
        //Compra
        Compra compra = compraDisco.getCompra();
        
        if(compra.getId() == null)
            throw new CreacionException("La creación de compras en la inserción de compras de discos no está permitida");
        
        if(this.repoCompra.obtenerPorId(compra.getId()) == null)
            throw new CreacionException("No existe la compra con la que intenta vincular la compra del disco");

        //Disco
        Disco disco = compraDisco.getDisco();
        
        if(disco.getId() == null)
            throw new CreacionException("La creación de discos en la inserción de compras de discos no está permitida");
        
        if(this.repoDisco.obtenerPorId(disco.getId()) == null)
            throw new CreacionException("No existe el disco con el que intenta vincular la compra del disco");
        
        //Validaciones relaciones
        if(this.repo.obtenerPorCompraYDisco(compra, disco) != null)
            throw new CreacionException("El disco no se puede registrar otra vez en la compra");
        
        this.repo.crear(compraDisco);
    }

    @Override
    public void editar(CompraDisco compraDisco) throws ObtencionException, EdicionException {
        if(compraDisco.getId() == null || this.repo.obtenerPorId(compraDisco.getId()) == null)
            throw new ObtencionException("La compra del disco a editar no existe");
        
        //Compra
        Compra compra = compraDisco.getCompra();
        
        if(compra.getId() == null)
            throw new EdicionException("La compra debe tener un id");
        
        if(this.repoCompra.obtenerPorId(compra.getId()) == null)
            throw new EdicionException("No existe la compra con la que intenta vincular la compra del disco");

        //Disco
        Disco disco = compraDisco.getDisco();
        
        if(disco.getId() == null)
            throw new EdicionException("El disco debe tener un id");
        
        if(this.repoDisco.obtenerPorId(disco.getId()) == null)
            throw new EdicionException("No existe el disco con el que intenta vincular la compra del disco");
        
        //Validaciones relaciones
        if(this.repo.obtenerPorCompraYDisco(compra, disco).getId().intValue() != compraDisco.getId().intValue())
            throw new EdicionException("El disco ya está registrado en la compra");
        
        this.repo.editar(compraDisco);
    }

    @Override
    public void eliminar(CompraDisco compraDisco) throws ObtencionException {
        if(compraDisco.getId() == null || this.repo.obtenerPorId(compraDisco.getId()) == null)
            throw new ObtencionException("La compra del disco a eliminar no existe");
        this.repo.eliminar(compraDisco);
    }

    @Override
    public void eliminarPorId(Integer id) throws ObtencionException {
        CompraDisco compraDisco = this.repo.obtenerPorId(id);
        if(compraDisco == null)
            throw new ObtencionException("La compra del disco a eliminar no existe");
        this.repo.eliminarPorId(id);
    }

    @Override
    public void retirarDisco(Disco disco, Compra compra) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentasDisco> obtenerVentas() throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
