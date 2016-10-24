/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.controlador;

import exceptions.EmptyStringException;
import exceptions.InvalidUserException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import joinme.GUI.ElegirArchivo;
import joinme.GUI.Perfil;
import joinme.GUI.PublicarEntrada;
import joinme.modelo.muro.GestorMuro;
import joinme.modelo.usuario.Usuario;

/**
 *
 * @author esteban
 */
public class ControladorPublicarEntrada {

    public ControladorPublicarEntrada(){
        
    }
    
    public void publicarEntrada(Usuario usuario, String mensaje, String media, String categoria, String visibilidad, PublicarEntrada aThis) {
        try {
            GestorMuro.getInstance().publicarEntrada(usuario, mensaje, media, categoria, visibilidad);
            Perfil perfil = new Perfil(usuario,usuario);
            perfil.setVisible(true);
            aThis.dispose();
        } catch (InvalidUserException ex) {
            Logger.getLogger(ControladorPublicarEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyStringException ex) {
            Logger.getLogger(ControladorPublicarEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void elegirArchivo(Usuario usuario, PublicarEntrada aThis) {
        ElegirArchivo elarchivo = new ElegirArchivo(usuario);
        elarchivo.setVisible(true);
        aThis.dispose();}

    public void getPerfil(Usuario usuario, PublicarEntrada aThis) {
        Perfil perfil = new Perfil(usuario,usuario);
        perfil.setVisible(true);
        aThis.dispose();
    }    

    public void elegirArchivo(Usuario usuario, JFileChooser jFileChooser1, ActionEvent evt, ElegirArchivo aThis) {
        PublicarEntrada pubEntrada;
        String command = evt.getActionCommand();
        if (command.equals("ApproveSelection")) {
            String archivo = jFileChooser1.getSelectedFile().getAbsolutePath();
            System.out.println(archivo);
            pubEntrada = new PublicarEntrada(usuario,archivo);
        }
        else{
            pubEntrada = new PublicarEntrada(usuario);
        }
        aThis.dispose();
        pubEntrada.setVisible(true);
    }
}
