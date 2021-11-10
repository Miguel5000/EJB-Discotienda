/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.service.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.dto.PaisDto;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.PaisDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Pais;
import co.edu.ucundinamarca.ejbdiscotienda.exception.CreacionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.EdicionException;
import co.edu.ucundinamarca.ejbdiscotienda.exception.ObtencionException;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IPaisRepo;
import co.edu.ucundinamarca.ejbdiscotienda.service.IPaisService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel
 */

@Stateless
public class PaisServiceImp implements IPaisService{

    @EJB
    private IPaisRepo repo;
    
    @Override
    public List<PaisDto> obtenerTodos() throws ObtencionException {
        List<Pais> paises = this.repo.obtenerTodos();
        if(paises == null || paises.isEmpty())
            throw new ObtencionException("No hay países disponibles");
        List<PaisDto> paisesDto = PaisDtoManager.convertir(paises);
        return paisesDto;
    }

    @Override
    public PaisDto obtenerPorId(Integer id) throws ObtencionException {
        Pais pais = this.repo.obtenerPorId(id);
        if(pais == null)
            throw new ObtencionException("El país no existe");
        PaisDto paisDto = PaisDtoManager.convertir(pais);
        return paisDto;
    }

    @Override
    public void crear(Pais pais) throws CreacionException {
        //Validaciones
        if(pais.getId() != null)
            throw new CreacionException("El id del país es autoincremental");
        
        //Prohibición de inserción con uno a muchos
        if(pais.getArtistas()!= null)
            throw new CreacionException("La inserción en cascada no está permitida");
        
        //Validaciones unicidad
        if(this.repo.obtenerPorNombre(pais.getNombre()) != null)
            throw new CreacionException("Ya existe un país con ese nombre");
        
        this.repo.crear(pais);
    }

    @Override
    public void editar(Pais pais) throws ObtencionException, EdicionException {
        if(pais.getId() == null || this.repo.obtenerPorId(pais.getId()) == null)
            throw new ObtencionException("El país a editar no existe");
        
        //Validaciones unicidad
        Pais paisPorNombre = this.repo.obtenerPorNombre(pais.getNombre());
        
        if(paisPorNombre != null && paisPorNombre.getId().intValue() != pais.getId().intValue())
            throw new EdicionException("Ya existe un país con ese nombre");
        
        this.repo.editar(pais);
    }

    @Override
    public void eliminar(Integer id) throws ObtencionException {
        Pais pais = this.repo.obtenerPorId(id);
        if(pais == null)
            throw new ObtencionException("El país a eliminar no existe");
        this.repo.eliminar(id);
    }
    
}
