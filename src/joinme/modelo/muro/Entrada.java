package joinme.modelo.muro;

import java.util.Calendar;

/**
 *
 * @author esteban
 */
public class Entrada extends Evento{

    private String media;
    private String categoria;
    private String visibilidad;

    public Entrada(String mensaje, String media, String categoria, String visibilidad) {
        super(mensaje);
        this.media = media;
        this.categoria = categoria;
        this.visibilidad = visibilidad;
    }

    public String getMedia(){
        return media;
    }
    
    public void setMedia(String media){
        this.media = media;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }
}
