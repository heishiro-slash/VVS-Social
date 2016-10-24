package joinme.modelo.muro;

import exceptions.EmptyStringException;
import exceptions.InvalidUserException;
import java.util.Calendar;
import joinme.modelo.usuario.Usuario;
/**
 *
 * @author esteban
 */
public class GestorMuro {
    
    private static GestorMuro instance;
    
    private GestorMuro(){
    }
    
    public static GestorMuro getInstance(){
        if(instance == null){
            instance = new GestorMuro();
        }
        return instance;
    }
    
    public Muro getMuro(Usuario usuario) throws InvalidUserException{
        if (usuario == null){
            throw new InvalidUserException("Null User");
        }
        return usuario.getMuro();
    }
    
    
    public void publicarEntrada(Usuario usuario,String mensaje) throws InvalidUserException, EmptyStringException{
        Muro muro = getMuro(usuario);
        if (mensaje.equals("")){
            throw new EmptyStringException("Empty Message");
        }
        Evento evento = new Evento(mensaje);
        muro.addEvento(evento);        
    }
    
    public void publicarEntrada(Usuario usuario, String mensaje, String media, String categoria, String visibilidad) throws InvalidUserException, EmptyStringException{
        Muro muro = getMuro(usuario);
        if (mensaje.equals("")||categoria.equals("")||visibilidad.equals("")){
            throw new EmptyStringException("Empty Message");
        }
        Evento evento = new Entrada(mensaje, media, categoria, visibilidad);
        muro.addEvento(evento);
    }
    
        
}
