/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import joinme.GUI.PagPrincipal;
import joinme.GUI.SolicitudAmistad;
import joinme.modelo.usuario.GestorUsuario;
import joinme.modelo.usuario.Solicitud;
import joinme.modelo.usuario.Usuario;

/**
 *
 * @author esteban
 */
public class ControladorSolicitudAmistad {
    public void ControladorSolicitudAmistad() {
        
    }

    public String getAlias(Usuario usuario) {
        return usuario.getAlias();
    }

    public List<String> getSolicitudes(Usuario usuario) {
        List <Solicitud> solicitudes;
        List <String> modelo1 = new ArrayList();
        
        solicitudes = usuario.getSolicitudes();
        if(!solicitudes.isEmpty()){
            for(Solicitud s:solicitudes){
                if(s.getEstado().equals("Pendiente")) {
                    modelo1.add(s.getSolicitante().getAlias());
                }
            }
            
        }
        return modelo1;
    }

    public void aceptarSolicitud(Usuario usuario, String solicitudSeleccionada, SolicitudAmistad aThis) {
        Usuario u = GestorUsuario.getInstance().getUsuario(usuario.getAlias());
        List <Solicitud> s  = u.getSolicitudes();
        for(Solicitud solicitud:s){
            if(solicitud.getSolicitante().getAlias().equals(solicitudSeleccionada)) {
                if (solicitud.getEstado().equals("Pendiente")) {
                    GestorUsuario.getInstance().aceptarSolicitud(solicitud);
                    //solicitud.setEstado("Aceptada");
                    JOptionPane.showMessageDialog(aThis, "Ahora eres amigo de: " + solicitud.getSolicitante().getAlias());
                }
            }
        }
    }

    public void rechazarSolicitud(Usuario usuario, String solicitudSeleccionada) {
        Usuario u = GestorUsuario.getInstance().getUsuario(usuario.getAlias());
        List <Solicitud> s  = u.getSolicitudes();
        for(Solicitud solicitud:s){
            if(solicitud.getSolicitante().getAlias().equals(solicitudSeleccionada)) {
                if (solicitud.getEstado().equals("Pendiente")) {
                    GestorUsuario.getInstance().rechazarSolicitud(solicitud);
                    //solicitud.setEstado("Rechazada");
                }
            }
        }
    }

    public void pagPrincipal(Usuario usuario, SolicitudAmistad aThis) {
        PagPrincipal pagPrincipal = new PagPrincipal(usuario);
        pagPrincipal.setVisible(true);
        aThis.dispose();
    }

}
