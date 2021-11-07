/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author Miguel
 */

@Entity
@Table(name = "artistas", schema = "artistas")
@NamedQueries({
    @NamedQuery(name = "Artista.obtenerTodos", query = "SELECT a FROM Artista a"),
    @NamedQuery(name = "Artista.eliminarPorId" , query = "DELETE FROM Artista a WHERE a.id = :id"),
    @NamedQuery(name = "Artista.obtenerPorFoto" , query = "SELECT a FROM Artista a WHERE a.foto = :foto"),
})

public class Artista {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "El artista debe tener un nombre")
    @Size(min = 1, max = 15, message = "Los nombres no pueden superar en conjunto los 15 caracteres")
    @Column(name = "nombres", nullable = false, length = 15)
    private String nombres;
    
    @NotNull(message = "El artista debe tener un apellido")
    @Size(min = 1, max = 15, message = "Los apellidos no pueden superar en conjunto los 15 caracteres")
    @Column(name = "apellidos", nullable = false, length = 15)
    private String apellidos;
    
    @Size(min = 1, max = 15, message = "El nombre artístico no puede superar los 15 caracteres")
    @Column(name = "nombre_artistico", nullable = true, length = 15)
    private String nombreArtistico;
    
    @NotNull(message = "El artista debe tener una fecha de nacimiento")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    @Column(name = "fecha_de_nacimiento", nullable = false)
    private Date fechaDeNacimiento;
    
    @Size(min = 1, max = 200, message = "El enlace de la foto no puede superar los 200 caracteres")
    @Column(name = "foto", nullable = true, length = 200, unique = true)
    private String foto;
    
    @Size(min = 1, message = "La cadena en base64 no puede estar vacía")
    private String fotoBase64;
    
    //Relaciones
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreadorDisco> creaciones;
    
    @NotNull(message = "El artista debe tener un género")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", nullable = false)
    private Genero genero;
    
    @NotNull(message = "El artista debe tener un país de origen")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;

    public Artista() {
    }

    public Artista(Integer id, String nombres, String apellidos, String nombreArtistico, Date fechaDeNacimiento, String foto, String fotoBase64) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreArtistico = nombreArtistico;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.foto = foto;
        this.fotoBase64 = fotoBase64;
    }

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
     * @return the fotoBase64
     */
    public String getFotoBase64() {
        return fotoBase64;
    }

    /**
     * @param fotoBase64 the fotoBase64 to set
     */
    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    /**
     * @return the creaciones
     */
    public List<CreadorDisco> getCreaciones() {
        return creaciones;
    }

    /**
     * @param creaciones the creaciones to set
     */
    public void setCreaciones(List<CreadorDisco> creaciones) {
        this.creaciones = creaciones;
    }

    /**
     * @return the genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
    
}
