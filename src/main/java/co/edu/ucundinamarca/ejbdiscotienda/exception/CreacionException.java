/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.ejbdiscotienda.exception;

/**
 * Clase que establece la excepción que se activa debido a problemas de creación
 * @author Miguel Ángel Manrique Téllez
 * @since 1.0.0
 * @version 1.0.0
 */
public class CreacionException extends Exception{
 
    /**
     * Constructor
     * @param mensaje variable que recibe el mensaje a mostrar por la excepción
     */
    public CreacionException(String mensaje) {
        super(mensaje);
    }
    
}
