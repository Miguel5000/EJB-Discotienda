/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.PaisDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Pais;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class PaisDtoManager {
 
    public static PaisDto convertir(Pais pais){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Pais, PaisDto> propiedad = new PropertyMap<Pais, PaisDto>() {
                @Override
                protected void configure() {
                    skip(destination.getArtistas());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(pais, PaisDto.class);
    
    }
    
    public static List<PaisDto> convertir(List<Pais> paises){
    
        List<PaisDto> paisesDto = new Vector<>();
        
        for (Pais pais : paises) {
         
            paisesDto.add(convertir(pais));
            
        }
        
        return paisesDto;
        
    }
    
}
