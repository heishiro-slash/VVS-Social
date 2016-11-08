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
import joinme.GUI.ListaAmigos;
import joinme.GUI.Login;
import joinme.GUI.PagPrincipal;
import joinme.GUI.Perfil;
import joinme.GUI.PublicarEntrada;
import joinme.GUI.SolicitudAmistad;
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
public class ControladorPaginaPrincipal {

    public ControladorPaginaPrincipal() {
        
    }
    
    public boolean getSolicitudesPendientes(Usuario usuario) {
        boolean pendientes = false;
        List <Solicitud> solicitudes;
        solicitudes = usuario.getSolicitudes();
        
        if(!solicitudes.isEmpty()){
            for(Solicitud s:solicitudes){
                if(s.getEstado().equals("Pendiente"))
                    pendientes = true;
            }
        } 
        return pendientes;
    }

    public List<Usuario> getAmigos(Usuario usuario) {
        return usuario.getAmigos();
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

    public List<String> getEventos(Usuario usuario, List<Usuario> amigos) {
        List <String> modelo = new ArrayList();
        Muro muro;
        Entrada entrada;
        List<Evento> eventos;
        
         for(Usuario amigo:amigos){
            try {
                muro = GestorMuro.getInstance().getMuro(amigo);
                eventos = muro.getEventos();
                for(Evento e:eventos) {
                    if(e instanceof Entrada){
                        entrada = (Entrada) e;
                        if (!entrada.getVisibilidad().equals("Privado"))
                            modelo.add(amigo.getAlias()+" - "+entrada.getFecha().getTime().toString()+" - "+entrada.getCategoria()+" - "+entrada.getVisibilidad()+" - "+entrada.getMensaje()+" - "+entrada.getMedia());
                    }
                    else
                        modelo.add(amigo.getAlias()+" - "+e.getFecha().getTime().toString()+" - "+e.getMensaje());
                }
            } catch (InvalidUserException ex) {
                Logger.getLogger(ControladorPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return modelo;
    }

    public List<String> getListaNoAmigos(Usuario usuario) {
        List <String> modelo2 = new ArrayList();
        List<Usuario> usuarios = GestorUsuario.getInstance().getUsuarios();
        for (Usuario u:usuarios){
            if(!usuario.esAmigo(u)&&!usuario.equals(u))
                modelo2.add(u.getAlias());
        }
        return modelo2;
    }

    public void verAmigosActionPerformed(Usuario usuario, PagPrincipal aThis) {
        ListaAmigos lista = new ListaAmigos(usuario,usuario);
        lista.setVisible(true);
        aThis.dispose();    
    }

    public void getPerfil(String alias, Usuario usuario, PagPrincipal aThis) {
        try {
            Usuario u = GestorUsuario.getInstance().getUsuario(alias);
            Perfil perfil = new Perfil(usuario,u);
            perfil.setVisible(true);
            aThis.dispose();
        } catch (EmptyStringException ex) {
            Logger.getLogger(ControladorPaginaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSolicitudes(Usuario usuario, PagPrincipal aThis) {
        SolicitudAmistad sa = new SolicitudAmistad(usuario);
        sa.setVisible(true);
        aThis.dispose();
    }

    public void publicarEntrada(Usuario usuario, PagPrincipal aThis) {
       PublicarEntrada pubEntrada = new PublicarEntrada(usuario);
       pubEntrada.setVisible(true);
       aThis.dispose();
    }

    public void getMiPerfil(Usuario usuario, PagPrincipal aThis) {
        Perfil perfil = new Perfil(usuario,usuario);
        perfil.setVisible(true);
        aThis.dispose();
    }

    public void desconectar(PagPrincipal aThis) {
        new Login().setVisible(true);
        aThis.dispose();
    }
}
