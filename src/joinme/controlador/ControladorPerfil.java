/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.controlador;

import exceptions.EmptyStringException;
import exceptions.InvalidUserException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import joinme.GUI.ListaAmigos;
import joinme.GUI.Login;
import joinme.GUI.PagPrincipal;
import joinme.GUI.Perfil;
import joinme.GUI.PublicarEntrada;
import joinme.modelo.muro.Entrada;
import joinme.modelo.muro.Evento;
import joinme.modelo.muro.GestorMuro;
import joinme.modelo.muro.Muro;
import joinme.modelo.usuario.GestorUsuario;
import joinme.modelo.usuario.Solicitud;
import joinme.modelo.usuario.Usuario;

/**
 *
 * @author esteban
 */
public class ControladorPerfil {

    public ControladorPerfil() {

    }

    public List<String> getEventos(Usuario usuario, Usuario usuarioConsultado) {
        List<String> modelo1 = new ArrayList();
        Entrada entrada;
        try {
            Muro muro = GestorMuro.getInstance().getMuro(usuario);
            List<Evento> eventos = muro.getEventos();

            for (Evento e : eventos) {
                if (e instanceof Entrada) {
                    entrada = (Entrada) e;
                    if (entrada.getVisibilidad().equals("Privado") && usuarioConsultado.equals(usuario)) {
                        modelo1.add(entrada.getFecha().getTime().toString() + " - " + entrada.getCategoria() + " - " + entrada.getVisibilidad() + " - " + entrada.getMensaje() + " - " + entrada.getMedia());
                    }
                    if (entrada.getVisibilidad().equals("Amigos") && (usuarioConsultado.esAmigo(usuario) || usuarioConsultado.equals(usuario))) {
                        modelo1.add(entrada.getFecha().getTime().toString() + " - " + entrada.getCategoria() + " - " + entrada.getVisibilidad() + " - " + entrada.getMensaje() + " - " + entrada.getMedia());
                    }
                    if (entrada.getVisibilidad().equals("Publico") || entrada.getVisibilidad().equals("Circulos")) {
                        modelo1.add(entrada.getFecha().getTime().toString() + " - " + entrada.getCategoria() + " - " + entrada.getVisibilidad() + " - " + entrada.getMensaje() + " - " + entrada.getMedia());
                    }

                } else {
                    modelo1.add(e.getFecha().getTime().toString() + " - " + e.getMensaje());
                }
            }
        } catch (InvalidUserException ex) {
            Logger.getLogger(ControladorPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo1;

    }

    public List<String> getListaNoAmigos(Usuario usuario) {
        List<String> modelo2 = new ArrayList();
        List<Usuario> usuarios = GestorUsuario.getInstance().getUsuarios();
        for (Usuario u : usuarios) {
            if (!usuario.esAmigo(u) && !usuario.equals(u)) {
                modelo2.add(u.getAlias());
            }
        }
        return modelo2;
    }

    public String getAlias(Usuario usuario) {
        return usuario.getAlias();
    }

    public String getNombre(Usuario usuario) {
        return usuario.getNombre();
    }

    public String getApellido1(Usuario usuario) {
        return usuario.getApellido1();
    }

    public String getApellido2(Usuario usuario) {
        return usuario.getApellido2();
    }

    public String getFechaNac(Usuario usuario) {
        return usuario.getFechaNac();
    }

    public void getPerfil(String alias, Usuario usuario, Perfil aThis) {
        try {
            Usuario u = GestorUsuario.getInstance().getUsuario(alias);
            Perfil perfil = new Perfil(usuario, u);
            perfil.setVisible(true);
            aThis.dispose();
        } catch (EmptyStringException ex) {
            Logger.getLogger(ControladorPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarSolicitud(Usuario usuario, Usuario usuarioConsultado, Perfil aThis) {
        usuarioConsultado.addSolicitud(new Solicitud(usuario, usuarioConsultado));
        JOptionPane.showMessageDialog(aThis, "Solicitud de amistad enviada a: " + usuarioConsultado.getAlias());
    }

    public void verAmigosActionPerformed(Usuario usuario, Usuario usuarioConsultado, Perfil aThis) {
        ListaAmigos lista = new ListaAmigos(usuario, usuarioConsultado);
        lista.setVisible(true);
        aThis.dispose();
    }

    public boolean esAmigo(Usuario usuario, Usuario usuarioConsultado) {
        boolean esAmigo = usuario.esAmigo(usuarioConsultado);
        return esAmigo;
    }

    public void publicarEntrada(Usuario usuario, Perfil aThis) {
        PublicarEntrada entrada = new PublicarEntrada(usuario);
        entrada.setVisible(true);
        aThis.dispose();
    }

    public void pagPrincipal(Usuario usuario, Perfil aThis) {
        PagPrincipal pagina = new PagPrincipal(usuario);
        pagina.setVisible(true);
        aThis.dispose();
    }

    public void desconectar(Perfil aThis) {
        new Login().setVisible(true);
        aThis.dispose();
    }

}
