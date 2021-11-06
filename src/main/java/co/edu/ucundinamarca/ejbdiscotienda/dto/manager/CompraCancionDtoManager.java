/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CompraCancionDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.CompraCancion;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class CompraCancionDtoManager {
    
    public static CompraCancionDto convertir(CompraCancion compraCancion){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<CompraCancion, CompraCancionDto> propiedad = new PropertyMap<CompraCancion, CompraCancionDto>() {
                @Override
                protected void configure() {
                    skip(destination.getCompra());
                    skip(destination.getCancion());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(compraCancion, CompraCancionDto.class);
    
    }
    
    public static List<CompraCancionDto> convertir(List<CompraCancion> comprasCanciones){
    
        List<CompraCancionDto> comprasCancionesDto = new Vector<>();
        
        for (CompraCancion compraCancion : comprasCanciones) {
         
            comprasCancionesDto.add(convertir(compraCancion));
            
        }
        
        return comprasCancionesDto;
        
    }
    
}
