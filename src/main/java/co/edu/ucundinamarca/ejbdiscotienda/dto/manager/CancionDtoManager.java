/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CancionDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Cancion;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class CancionDtoManager {
    
    public static CancionDto convertir(Cancion cancion){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Cancion, CancionDto> propiedad = new PropertyMap<Cancion, CancionDto>() {
                @Override
                protected void configure() {
                    //skip(destination.getFormato());
                    //skip(destination.getDisco());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(cancion, CancionDto.class);
    
    }
    
    public static List<CancionDto> convertir(List<Cancion> canciones){
    
        List<CancionDto> cancionesDto = new Vector<>();
        
        for (Cancion cancion : canciones) {
         
            cancionesDto.add(convertir(cancion));
            
        }
        
        return cancionesDto;
        
    }
    
}
