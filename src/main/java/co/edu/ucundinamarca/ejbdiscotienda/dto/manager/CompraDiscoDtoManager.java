/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CompraDiscoDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraDisco;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class CompraDiscoDtoManager {
    
    public static CompraDiscoDto convertir(CompraDisco compraDisco){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<CompraDisco, CompraDiscoDto> propiedad = new PropertyMap<CompraDisco, CompraDiscoDto>() {
                @Override
                protected void configure() {
                    skip(destination.getCompra());
                    skip(destination.getDisco());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(compraDisco, CompraDiscoDto.class);
    
    }
    
    public static List<CompraDiscoDto> convertir(List<CompraDisco> comprasDiscos){
    
        List<CompraDiscoDto> comprasDiscosDto = new Vector<>();
        
        for (CompraDisco compraDisco : comprasDiscos) {
         
            comprasDiscosDto.add(convertir(compraDisco));
            
        }
        
        return comprasDiscosDto;
        
    }
    
}
