/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joinme.controlador;

import javax.swing.JOptionPane;
import joinme.GUI.FormularioRegistro;
import joinme.GUI.Login;
import joinme.GUI.PagPrincipal;
import joinme.modelo.muro.GestorMuro;
import joinme.modelo.usuario.GestorUsuario;
import joinme.modelo.usuario.Solicitud;
import joinme.modelo.usuario.Usuario;

/**
 *
 * @author esteban
 */
public class ControladorLogin {
    public ControladorLogin() {
        
    }

    public void login(String usuarioDefecto, String usuario, Login aThis) {
       GestorUsuario gu = GestorUsuario.getInstance();
              
        if (usuario.equals(usuarioDefecto)||gu.existeUsuario(usuario)){
            PagPrincipal principal = new PagPrincipal(gu.getUsuario(usuario));
            principal.setVisible(true);
            aThis.dispose();
        } else {
            JOptionPane.showMessageDialog(aThis, "usuario incorrecto");
        }
    }

    public void registro(Login aThis) {
        FormularioRegistro registro=new FormularioRegistro();
        registro.setVisible(true);
        aThis.dispose();
    }

    public void creacionDatos(String usuarioDefecto){
        GestorUsuario gu = GestorUsuario.getInstance();
        if(!gu.existeUsuario(usuarioDefecto)) {
            Usuario uEduardo = gu.altaUsuario("Eduardo", "Gomez", "Gomez", usuarioDefecto, "05/01/78", "");
            Usuario uEsteban = gu.altaUsuario("Esteban", "Abanqueiro", "Agrelo", "Aba", "05/03/89", "");
            Usuario uVictor = gu.altaUsuario("Victor", "Blanco", "", "Victor", "10/03/89", "");
            Usuario uFaustino = gu.altaUsuario("Faustino", "Castro", "", "Tino", "20/03/89", "");
            Usuario uJose = gu.altaUsuario("Jose", "Miguel", "del Rio", "Jose", "16/03/89", "");
            uEsteban.registrarAmistad(uVictor);
            uEsteban.registrarAmistad(uFaustino);
            uEsteban.registrarAmistad(uJose);
            uVictor.registrarAmistad(uFaustino);
            uVictor.registrarAmistad(uEsteban);
            uFaustino.registrarAmistad(uVictor);
            uFaustino.registrarAmistad(uEsteban);
            uJose.registrarAmistad(uEsteban);
            uJose.registrarAmistad(uEduardo);
            uEduardo.registrarAmistad(uJose);
            GestorMuro.getInstance().publicarEntrada(uEsteban, "Mesaje de Esteban", null, "Tecnologia", "Amigos");
            GestorMuro.getInstance().publicarEntrada(uEsteban, "Mesaje de Esteban2", null, "Humor", "Publico");
            GestorMuro.getInstance().publicarEntrada(uVictor, "Mesaje de Victor", null, "Tecnologia", "Amigos");
            GestorMuro.getInstance().publicarEntrada(uFaustino, "Mesaje de Faustino", null, "Humor", "Publico");
            GestorMuro.getInstance().publicarEntrada(uJose, "Mesaje de Jose", null, "Humor", "Publico");
            GestorMuro.getInstance().publicarEntrada(uEduardo, "Mesaje de Eduardo", null, "Tecnologia", "Amigos");
            GestorMuro.getInstance().publicarEntrada(uEduardo, "Mesaje de Eduardo1", null, "Humor", "Publico");
            GestorMuro.getInstance().publicarEntrada(uEduardo, "Mesaje de Eduardo2", null, "Humor", "Publico");
            uJose.addSolicitud(new Solicitud(uVictor,uJose));
            uEduardo.addSolicitud(new Solicitud(uVictor,uEduardo));
            uEduardo.addSolicitud(new Solicitud(uFaustino,uEduardo));
        }
    }
}
