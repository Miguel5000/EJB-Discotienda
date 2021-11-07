/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.dto.manager;

import co.edu.ucundinamarca.ejbdiscotienda.dto.UsuarioDto;
import co.edu.ucundinamarca.ejbdiscotienda.entity.Usuario;
import java.util.List;
import java.util.Vector;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Miguel
 */
public class UsuarioDtoManager {
    
    public static UsuarioDto convertir(Usuario usuario){
    
        ModelMapper mapeador = new ModelMapper();
        
        PropertyMap<Usuario, UsuarioDto> propiedad = new PropertyMap<Usuario, UsuarioDto>() {
                @Override
                protected void configure() {
                    skip(destination.getCompras());
                    //skip(destination.getRol());
                }
         };
        
        mapeador.addMappings(propiedad);
        
        return mapeador.map(usuario, UsuarioDto.class);
    
    }
    
    public static List<UsuarioDto> convertir(List<Usuario> usuarios){
    
        List<UsuarioDto> usuariosDto = new Vector<>();
        
        for (Usuario usuario : usuarios) {
         
            usuariosDto.add(convertir(usuario));
            
        }
        
        return usuariosDto;
        
    }
    
}
