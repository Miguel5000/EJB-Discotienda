/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.DiscoDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Disco;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class DiscoDtoManager {
    
    public static DiscoDto convertir(Disco disco){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Disco, DiscoDto> propiedad = new PropertyMap<Disco, DiscoDto>() {
                @Override
                protected void configure() {
                    skip(destination.getCompras());
                    skip(destination.getCreaciones());
                    skip(destination.getCanciones());
                    skip(destination.getPortadaEnBytes());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(disco, DiscoDto.class);
    
    }
    
    public static List<DiscoDto> convertir(List<Disco> discos){
    
        List<DiscoDto> discosDto = new Vector<>();
        
        for (Disco disco : discos) {
         
            discosDto.add(convertir(disco));
            
        }
        
        return discosDto;
        
    }
    
}
