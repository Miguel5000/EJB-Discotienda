/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CompraDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CompraDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Carrito;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICompraRepo;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IUsuarioRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.ICompraService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class CompraServiceImp implements ICompraService{

    @EJB
    private ICompraRepo repo;
    
    @EJB
    private IUsuarioRepo repoUsuario;
    
    @Override
    public List<CompraDto> obtenerTodos() throws ObtencionException {
        List<Compra> compras = this.repo.obtenerTodos();
        if(compras == null || compras.isEmpty())
            throw new ObtencionException("No hay compras disponibles");
        List<CompraDto> comprasDto = CompraDtoManager.convertir(compras);
        return comprasDto;
    }

    @Override
    public CompraDto obtenerPorId(Integer id) throws ObtencionException {
        Compra compra = this.repo.obtenerPorId(id);
        if(compra == null)
            throw new ObtencionException("La compra no existe");
        CompraDto compraDto = CompraDtoManager.convertir(compra);
        return compraDto;
    }

    @Override
    public void crear(Compra compra) throws CreacionException{
        //Validaciones
        if(compra.getId() != null)
            throw new CreacionException("El id de la compra de la canción es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(compra.getComprasCanciones()!= null || compra.getComprasDiscos() != null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        //Usuario
        Usuario usuario = compra.getUsuario();
        
        if(usuario.getId() == null)
            throw new CreacionException("La creación de usuarios en la inserción de compras no está permitida");
        
        if(this.repoUsuario.obtenerPorId(usuario.getId()) == null)
            throw new CreacionException("No existe el usuario con el que intenta vincular la compra");

        //Validaciones relaciones
        if(!compra.getRealizacion() && this.repo.obtenerCarrito(usuario) != null)
            throw new CreacionException("No se puede tener más de una compra que represente al carrito");
        
        this.repo.crear(compra);
    }

    @Override
    public void editar(Compra compra) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Compra compra) throws ObtencionException {
        if(compra.getId() == null || this.repo.obtenerPorId(compra.getId()) == null)
            throw new ObtencionException("La compra a eliminar no existe");
        this.repo.eliminar(compra);
    }

    @Override
    public void eliminarPorId(Integer id) throws ObtencionException {
        Compra compra = this.repo.obtenerPorId(id);
        if(compra == null)
            throw new ObtencionException("La compra a eliminar no existe");
        this.repo.eliminarPorId(id);
    }

    @Override
    public void comprar(Compra compra) throws ObtencionException {
        
    }

    @Override
    public Carrito obtenerCarrito(Usuario usuario) throws ObtencionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
