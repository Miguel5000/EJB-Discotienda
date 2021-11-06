/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.GeneroDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Genero;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class GeneroDtoManager {
    
    public static GeneroDto convertir(Genero genero){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Genero, GeneroDto> propiedad = new PropertyMap<Genero, GeneroDto>() {
                @Override
                protected void configure() {
                    skip(destination.getArtistas());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(genero, GeneroDto.class);
    
    }
    
    public static List<GeneroDto> convertir(List<Genero> generos){
    
        List<GeneroDto> generosDto = new Vector<>();
        
        for (Genero genero : generos) {
         
            generosDto.add(convertir(genero));
            
        }
        
        return generosDto;
        
    }
    
}
