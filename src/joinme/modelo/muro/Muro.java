package joinme.modelo.muro;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class Muro {
    private String mensaje;
    List <Evento> eventos;
    public Muro(){
        mensaje = null;
        eventos = new ArrayList<>();
    }
    public void addEvento(Evento evento){
        eventos.add(evento);
    }
    public List<Evento> getEventos(){
        return eventos;
    }
}
