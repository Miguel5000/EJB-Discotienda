/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.CompraDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Compra;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class CompraDtoManager {
    
    public static CompraDto convertir(Compra compra){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Compra, CompraDto> propiedad = new PropertyMap<Compra, CompraDto>() {
                @Override
                protected void configure() {
                    skip(destination.getComprasCanciones());
                    skip(destination.getComprasDiscos());
                    //skip(destination.getUsuario());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(compra, CompraDto.class);
    
    }
    
    public static List<CompraDto> convertir(List<Compra> compras){
    
        List<CompraDto> comprasDto = new Vector<>();
        
        for (Compra compra : compras) {
         
            comprasDto.add(convertir(compra));
            
        }
        
        return comprasDto;
        
    }
    
}
