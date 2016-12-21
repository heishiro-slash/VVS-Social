/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.modelo.usuario;

/**
 *
 * @author esteban
 */
public class GestorPerfil {
    private static GestorPerfil instancePerfil;
    
     private GestorPerfil() {
    }
    
    public static GestorPerfil getInstance(){
        if(instancePerfil == null){
            instancePerfil = new GestorPerfil();
        }
        return instancePerfil;
    }
}
