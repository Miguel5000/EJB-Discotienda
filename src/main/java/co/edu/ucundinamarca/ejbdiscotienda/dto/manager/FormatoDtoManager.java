/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.FormatoDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Formato;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class FormatoDtoManager {
    
    public static FormatoDto convertir(Formato formato){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Formato, FormatoDto> propiedad = new PropertyMap<Formato, FormatoDto>() {
                @Override
                protected void configure() {
                    skip(destination.getCanciones());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(formato, FormatoDto.class);
    
    }
    
    public static List<FormatoDto> convertir(List<Formato> formatos){
    
        List<FormatoDto> formatosDto = new Vector<>();
        
        for (Formato formato : formatos) {
         
            formatosDto.add(convertir(formato));
            
        }
        
        return formatosDto;
        
    }
    
}
