/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;


import co.edu.ucundinamarca.ejbdiscotienda.dto.DiscoDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.DiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IDiscoRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.IDiscoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class DiscoServiceImp implements IDiscoService{

    @EJB
    private IDiscoRepo repo;
    
    @Override
    public List<DiscoDto> obtenerTodos() throws ObtencionException {
        List<Disco> discos = this.repo.obtenerTodos();
        if(discos == null || discos.isEmpty())
            throw new ObtencionException("No hay discos disponibles");
        List<DiscoDto> discosDto = DiscoDtoManager.convertir(discos);
        return discosDto;
    }

    @Override
    public DiscoDto obtenerPorId(Integer id) throws ObtencionException {
        Disco disco = this.repo.obtenerPorId(id);
        if(disco == null)
            throw new ObtencionException("El disco no existe");
        DiscoDto discoDto = DiscoDtoManager.convertir(disco);
        return discoDto;
    }
    
    @Override
    public List<DiscoDto> obtenerPorArtista(Integer id) throws ObtencionException {
        List<Disco> discos = this.repo.obtenerListaPorArtista(id);
        if(discos == null || discos.isEmpty())
            throw new ObtencionException("El artista no tiene discos");
        List<DiscoDto> discosDto = DiscoDtoManager.convertir(discos);
        return discosDto;
    }

    @Override
    public void crear(Disco disco) throws CreacionException{
        //Validaciones
        if(disco.getId() != null)
            throw new CreacionException("El id del disco es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(disco.getCanciones() != null || disco.getCompras() != null || disco.getCreaciones() != null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        this.repo.crear(disco);
    }

    @Override
    public void editar(Disco disco) throws ObtencionException {
        if(disco.getId() == null || this.repo.obtenerPorId(disco.getId()) == null)
            throw new ObtencionException("El disco a editar no existe");
        
        this.repo.editar(disco);
    }

    @Override
    public void eliminar(Integer id) throws ObtencionException {
        Disco disco = this.repo.obtenerPorId(id);
        if(disco == null)
            throw new ObtencionException("El disco a eliminar no existe");
        this.repo.eliminar(id);
    }

}
