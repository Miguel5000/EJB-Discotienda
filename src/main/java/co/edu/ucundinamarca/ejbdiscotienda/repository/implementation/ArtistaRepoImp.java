/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.repository.implementation;

import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import co.edu.ucundinamarca.ejbdiscotienda.repository.IArtistaRepo;
import co.edu.ucundinamarca.ejbdiscotienda.view.VentasArtista;
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
public class ArtistaRepoImp implements IArtistaRepo{

    @PersistenceContext(unitName = "conexionPostgresql")
    private EntityManager manager;
    
    @Override
    public List<VentasArtista> obtenerVentas() {
        TypedQuery<VentasArtista> query = this.manager.createNamedQuery("VentasArtista.obtenerTodos", VentasArtista.class);
        return query.getResultList();
    }

    @Override
    public List<Artista> obtenerTodos() {
        TypedQuery<Artista> query = this.manager.createNamedQuery("Artista.obtenerTodos", Artista.class);
        return query.getResultList();
    }

    @Override
    public Artista obtenerPorId(Integer id) {
        return this.manager.find(Artista.class, id);
    }

    @Override
    public void crear(Artista artista) {
        this.manager.persist(artista);
    }

    @Override
    public void editar(Artista artista) {
        Artista artistaOriginal = this.obtenerPorId(artista.getId());
        artistaOriginal.setApellidos(artista.getApellidos());
        artistaOriginal.setFechaDeNacimiento(artista.getFechaDeNacimiento());
        if(artista.getFoto() != null)
            artistaOriginal.setFoto(artista.getFoto());
        artistaOriginal.setGenero(artista.getGenero());
        artistaOriginal.setNombreArtistico(artista.getNombreArtistico());
        artistaOriginal.setNombres(artista.getNombres());
        artistaOriginal.setPais(artista.getPais());
    }

    @Override
    public void eliminar(Artista artista) {
        this.manager.remove(artista);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Query eliminacion = manager.createNamedQuery("Artista.eliminarPorId");
        eliminacion.setParameter("id", id);
        eliminacion.executeUpdate();
    }

    @Override
    public Artista obtenerPorFoto(String foto) {
        TypedQuery<Artista> query = this.manager.createNamedQuery("Artista.obtenerPorFoto", Artista.class);
        query.setParameter("foto", foto);
        return query.getSingleResult();
    }
    
}
