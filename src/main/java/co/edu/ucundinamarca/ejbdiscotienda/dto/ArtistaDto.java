/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto;

import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.CreadorDiscoDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.GeneroDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.dto.manager.PaisDtoManager;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CreadorDisco;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Genero;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Pais;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class ArtistaDto{
    
    private Integer id;
    private String nombres;
    private String apellidos;
    private String nombreArtistico;
    private Date fechaDeNacimiento;
    private String foto;
    private Byte[] fotoEnBytes;
    private List<CreadorDiscoDto> creaciones;
    private GeneroDto genero;
    private PaisDto pais;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the nombreArtistico
     */
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    /**
     * @param nombreArtistico the nombreArtistico to set
     */
    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    /**
     * @return the fechaDeNacimiento
     */
    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * @param fechaDeNacimiento the fechaDeNacimiento to set
     */
    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the fotoEnBytes
     */
    public Byte[] getFotoEnBytes() {
        return fotoEnBytes;
    }

    /**
     * @param fotoEnBytes the fotoEnBytes to set
     */
    public void setFotoEnBytes(Byte[] fotoEnBytes) {
        this.fotoEnBytes = fotoEnBytes;
    }    

     
    /**
     * @return the creaciones
     */
    public List<CreadorDiscoDto> getCreaciones() {
        return creaciones;
    }

    /**
     * @param creaciones the creaciones to set
     */
    public void setCreaciones(List<CreadorDisco> creaciones) {
        this.creaciones = CreadorDiscoDtoManager.convertir(creaciones);
    }

    /**
     * @return the genero
     */
    public GeneroDto getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Genero genero) {
        this.genero = GeneroDtoManager.convertir(genero);
    }

    /**
     * @return the pais
     */
    public PaisDto getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = PaisDtoManager.convertir(pais);
    }
    
    
}
