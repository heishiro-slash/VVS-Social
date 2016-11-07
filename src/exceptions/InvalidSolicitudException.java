/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Uxía
 */
public class InvalidSolicitudException extends Exception {
    
    private String message = null;

    public InvalidSolicitudException() {
        super();
    }

    public InvalidSolicitudException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
