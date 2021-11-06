/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CreadorDiscoDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CreadorDisco;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class CreadorDiscoDtoManager {
    
    public static CreadorDiscoDto convertir(CreadorDisco creadorDisco){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<CreadorDisco, CreadorDiscoDto> propiedad = new PropertyMap<CreadorDisco, CreadorDiscoDto>() {
                @Override
                protected void configure() {
                    skip(destination.getArtista());
                    skip(destination.getDisco());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(creadorDisco, CreadorDiscoDto.class);
    
    }
    
    public static List<CreadorDiscoDto> convertir(List<CreadorDisco> creadoresDiscos){
    
        List<CreadorDiscoDto> creadoresDiscosDto = new Vector<>();
        
        for (CreadorDisco creadorDisco : creadoresDiscos) {
         
            creadoresDiscosDto.add(convertir(creadorDisco));
            
        }
        
        return creadoresDiscosDto;
        
    }
    
}
