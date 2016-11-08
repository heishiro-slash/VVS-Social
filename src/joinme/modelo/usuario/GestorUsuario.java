package joinme.modelo.usuario;

import exceptions.EmptyStringException;
import exceptions.InvalidSolicitudException;
import exceptions.InvalidUserException;
import java.util.ArrayList;
import java.util.List;
import joinme.modelo.muro.Evento;
import joinme.modelo.muro.GestorMuro;

/**
 *
 * @author esteban
 */
public class GestorUsuario {
    
    private static GestorUsuario instanceUsuario;
    private static GestorMuro instanceMuro;
    private List<Usuario> usuarios;
    
    private GestorUsuario() {
        usuarios = new ArrayList<Usuario>();
        instanceMuro.getInstance();
    }
    
    public static GestorUsuario getInstance(){
        if(instanceUsuario == null){
            instanceUsuario = new GestorUsuario();
        }
        return instanceUsuario;
    }
    
    
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    
    
    
    public Usuario altaUsuario(String nombre, String apellido1, 
            String apellido2, String alias, String fechaNac, String contraseña) throws EmptyStringException{
        if(alias == "" || contraseña =="") {
            throw new EmptyStringException();
        }
        
        Usuario u = new Usuario(nombre, apellido1, apellido2, alias, fechaNac, contraseña);
        usuarios.add(u);
        return u;
    }
    
    public Usuario getUsuario(String alias) throws EmptyStringException{
        if(alias == ""){
            throw new EmptyStringException ();
        }
        for(Usuario u: usuarios){
            if(u.getAlias().equals(alias))
                return u;
        }
        return null;
    }
    public boolean existeUsuario(String alias){
        for(Usuario u: usuarios){
            if(u.getAlias().equals(alias))
                return true;
        }
        return false;
    }
    
    public List<Usuario> buscarUsuario(String nombre, String ap1, String ap2) throws EmptyStringException{
        if((nombre.equals("") && ap1.equals("")) && ap2.equals("")){
            throw new EmptyStringException();
        } else {
        }
        
        List<Usuario> listaUsuarios = null;
        return listaUsuarios;
    }
    
    public void aceptarSolicitud(Solicitud s) throws InvalidSolicitudException, InvalidUserException, EmptyStringException{
        if(s == null){
            throw new InvalidSolicitudException("Null solicitud");
        }
        Usuario solicitado = s.getSolicitado();
        Usuario solicitante = s.getSolicitante();
        solicitado.aceptarSolicitud(s);
        solicitado.registrarAmistad(solicitante);
        solicitante.registrarAmistad(solicitado);
    }
    
    public void rechazarSolicitud(Solicitud s) throws InvalidSolicitudException{
        if (s == null){
            throw new InvalidSolicitudException("Null solicitud");
        }
        Usuario solicitado = s.getSolicitado();
        solicitado.rechazarSolicitud(s);
    }
    
    public List<Usuario> verAmigos(Usuario usuario) throws InvalidUserException {
        if (usuario == null){
            throw new InvalidUserException("Null user");
        }
        return usuario.getAmigos();
    }
    
    
    //Funcion solo necesaria para meter datos
    public void anadirAmigo(Usuario usuario, String alias) throws InvalidUserException, EmptyStringException{
        if ( usuario == null ){
            throw new InvalidUserException("Null User");
        }
        
        if ( alias.equals("") ){
            throw new EmptyStringException("Alias vacio");
        }
        if(existeUsuario(alias)){
            Usuario amigo = getUsuario(alias);
            if(!usuario.esAmigo(amigo)){
                usuario.registrarAmistad(getUsuario(alias));        
            }
        }
    }

    private void EmptyStringException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
