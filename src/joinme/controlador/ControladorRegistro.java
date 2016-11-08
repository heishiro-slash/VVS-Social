/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.controlador;

import exceptions.EmptyStringException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import joinme.GUI.FormularioRegistro;
import joinme.GUI.PagPrincipal;
import joinme.modelo.usuario.GestorUsuario;

/**
 *
 * @author esteban
 */
public class ControladorRegistro {
    public ControladorRegistro(){
        
    }

    public void registrar(String alias, String nombre, String ap1, String ap2, String fecNac, String pass, FormularioRegistro aThis) {
        try {
            GestorUsuario gu = GestorUsuario.getInstance();
            gu.altaUsuario(nombre, ap1, ap2, alias, fecNac, pass);
            
            if ( !nombre.equals("") && !alias.equals("") && !pass.equals("") ){
                if(gu.existeUsuario(alias)){
                    JOptionPane.showMessageDialog(aThis, "Usuario creado con éxito");
                    
                    PagPrincipal principal = new PagPrincipal(gu.getUsuario(alias));
                    principal.setVisible(true);
                    aThis.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(aThis, "Hubo un error en la creacion del usuario");
                }
            } else {
                JOptionPane.showMessageDialog(aThis, "Debe completar los campos obligatorios");
            }
        } catch (EmptyStringException ex) {
            Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
