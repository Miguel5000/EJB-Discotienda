/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import co.edu.ucundinamarca.ejbdiscotienda.repository.ICancionRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Miguel
 */

@Stateless
public class CancionRepoImp implements ICancionRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<Cancion> obtenerListaPorCompra(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cancion> obtenerListaPorDisco(Disco disco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cancion> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cancion obtenerPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear(Cancion entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Cancion entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Cancion entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
