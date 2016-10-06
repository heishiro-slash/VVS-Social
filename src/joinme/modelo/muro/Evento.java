package joinme.modelo.muro;

import java.util.Calendar;

/**
 *
 * @author esteban
 */
public class Evento {
    
    private String mensaje;
    private Calendar fecha;
    
    public Evento(String mensaje){
        this.mensaje = mensaje;
        this.fecha = Calendar.getInstance();
    }
    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
}
