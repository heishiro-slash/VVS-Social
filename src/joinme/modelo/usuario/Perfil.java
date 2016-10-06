package joinme.modelo.usuario;

/**
 *
 * @author esteban
 */
public class Perfil {
    private String foto;
    
    private String diseño;

    public Perfil(String foto, String diseño) {
        this.foto = foto;
        this.diseño = diseño;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDiseño() {
        return diseño;
    }

    public void setDiseño(String diseño) {
        this.diseño = diseño;
    }
    
    
}
