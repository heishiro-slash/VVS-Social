/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.controlador;

import java.util.List;
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
        Perfil perfil = new Perfil(usuario,usuarioConsultado);
        perfil.setVisible(true);
        aThis.dispose();
    }

    public void verAmigos(Usuario usuario, String valor, ListaAmigos aThis) {
        Usuario u =gu.getUsuario(valor);
        Perfil perfil = new Perfil(usuario,u);
        perfil.setVisible(true); // muestra la ventana de PagPrincipal
        aThis.dispose();}

    public List<Usuario> getAmigos(Usuario usuarioConsultado) {
        return gu.verAmigos(usuarioConsultado);
    }

    public Object getAlias(Usuario u) {
        return u.getAlias();
    }
}
