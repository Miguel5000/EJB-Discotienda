/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.exception;

/**
 *
 * @author Miguel
 */
public class ObtencionException extends Exception  {
    
    /**
     * Constructor
     * @param mensaje variable que recibe el mensaje a mostrar por la excepción
     */
    public ObtencionException(String mensaje){
    
        super(mensaje);
    
    }
    
}
