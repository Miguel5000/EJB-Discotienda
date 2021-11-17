/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.ArtistaDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Artista;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class ArtistaDtoManager {
    
    public static ArtistaDto convertir(Artista artista){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Artista, ArtistaDto> propiedad = new PropertyMap<Artista, ArtistaDto>() {
                @Override
                protected void configure() {
                    skip(destination.getCreaciones());
                    skip(destination.getFotoEnBytes());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(artista, ArtistaDto.class);
    
    }
    
    public static List<ArtistaDto> convertir(List<Artista> artistas){
    
        List<ArtistaDto> artistasDto = new Vector<>();
        
        for (Artista artista : artistas) {
         
            artistasDto.add(convertir(artista));
            
        }
        
        return artistasDto;
        
    }
    
}
