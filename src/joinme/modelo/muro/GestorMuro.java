package joinme.modelo.muro;

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
    
    public Muro getMuro(Usuario usuario){
        return usuario.getMuro();
    }
    
    
    public void publicarEntrada(Usuario usuario,String mensaje){
        Muro muro = getMuro(usuario);
        Evento evento = new Evento(mensaje);
        muro.addEvento(evento);        
    }
    
    public void publicarEntrada(Usuario usuario, String mensaje, String media, String categoria, String visibilidad){
        Muro muro = getMuro(usuario);
        Evento evento = new Entrada(mensaje, media, categoria, visibilidad);
        muro.addEvento(evento);
    }
    
        
}
