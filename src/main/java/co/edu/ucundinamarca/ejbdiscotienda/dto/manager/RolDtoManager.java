/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.RolDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Rol;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class RolDtoManager {
    
    public static RolDto convertir(Rol rol){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Rol, RolDto> propiedad = new PropertyMap<Rol, RolDto>() {
                @Override
                protected void configure() {
                    skip(destination.getUsuarios());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(rol, RolDto.class);
    
    }
    
    public static List<RolDto> convertir(List<Rol> roles){
    
        List<RolDto> rolesDto = new Vector<>();
        
        for (Rol rol : roles) {
         
            rolesDto.add(convertir(rol));
            
        }
        
        return rolesDto;
        
    }
    
}
