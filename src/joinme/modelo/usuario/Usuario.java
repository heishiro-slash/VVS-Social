package joinme.modelo.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import joinme.modelo.muro.Evento;
import joinme.modelo.muro.GestorMuro;
import joinme.modelo.muro.Muro;

/**
 *
 * @author esteban
 */
public class Usuario {
    private String nombre;
    
    private String apellido1;
    
    private String apellido2;
    
    private String alias;
    
    private String fechaNac;
    
    private String contraseña;
    
    private Muro muro;    
    
    private List<Usuario> amigos;
    private List<Solicitud> solicitudes;

    public Usuario(String nombre, String apellido1, String apellido2, String alias, String fechaNac, String contraseña) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.alias = alias;
        this.fechaNac = fechaNac;
        this.contraseña = contraseña;
        muro = new Muro();
        amigos = new ArrayList();
        solicitudes = new CopyOnWriteArrayList();
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public Muro getMuro(){
        return muro;
    }
    
    //FINAL GETTERS Y SETTERS
    
    public void comprobarAcceso(){   
    }
    
    public void registrarAmistad(Usuario usuario){
        GestorMuro.getInstance().publicarEntrada(this, alias + " ahora es amigo de " + usuario.getAlias());
        amigos.add(usuario);
    }
    
    public boolean esAmigo(Usuario usuario){
        return amigos.contains(usuario);
    }
    
    public List<Usuario> getAmigos(){
        return amigos;
    }
    
    public List<Solicitud>getSolicitudes(){
        return solicitudes;
    }
    public void addSolicitud(Solicitud s){
        boolean repetida= false;
        for(Solicitud solicitud:solicitudes)
            if(solicitud.getSolicitante().equals(s.getSolicitante())&&solicitud.getEstado().equals("Pendiente"))
                repetida = true;
        if(!repetida)
            solicitudes.add(s);
    }
    public void rechazarSolicitud(Solicitud s){
        solicitudes.remove(s);
        s.setEstado("Rechazada");
        solicitudes.add(s);
    }
    
    public void aceptarSolicitud(Solicitud s){
        solicitudes.remove(s);
        s.setEstado("Aceptada");
        solicitudes.add(s);
    }
}
