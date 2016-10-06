package joinme.modelo.usuario;

import java.util.Calendar;

/**
 *
 * @author esteban
 */
public class Solicitud {
    private Usuario solicitante;
    private Usuario solicitado;
    private String estado;
    private Calendar fechaSolicitud;

    public Solicitud(Usuario solicitante, Usuario solicitado) {
        this.solicitante = solicitante;
        this.solicitado = solicitado;
        this.estado = "Pendiente";
        this.fechaSolicitud = Calendar.getInstance();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Calendar getFechaSolicitud() {
        return fechaSolicitud;
    }
    public Usuario getSolicitante(){
        return solicitante;
    }
    public Usuario getSolicitado(){
        return solicitado;
    }
    public void setFechaSolicitud(Calendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
