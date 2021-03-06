/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.controlador;

import exceptions.EmptyStringException;
import exceptions.InvalidUserException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import joinme.GUI.ListaAmigos;
import joinme.GUI.Perfil;
import joinme.modelo.usuario.GestorUsuario;
import joinme.modelo.usuario.Usuario;

/**
 *
 * @author esteban
 */
public class ControladorListaAmigos {

    GestorUsuario gu = GestorUsuario.getInstance();

    public ControladorListaAmigos() {

    }

    public void getPerfil(Usuario usuario, Usuario usuarioConsultado, ListaAmigos aThis) {
        Perfil perfil = new Perfil(usuario, usuarioConsultado);
        perfil.setVisible(true);
        aThis.dispose();
    }

    public void verAmigos(Usuario usuario, String valor, ListaAmigos aThis) {
        try {
            Usuario u = gu.getUsuario(valor);
            Perfil perfil = new Perfil(usuario, u);
            perfil.setVisible(true); // muestra la ventana de PagPrincipal
            aThis.dispose();
        } catch (EmptyStringException ex) {
            Logger.getLogger(ControladorListaAmigos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> getAmigos(Usuario usuarioConsultado) {
        try {
            return gu.verAmigos(usuarioConsultado);
        } catch (InvalidUserException e) {
            return null;
        }

    }

    public Object getAlias(Usuario u) {
        return u.getAlias();
    }
}
