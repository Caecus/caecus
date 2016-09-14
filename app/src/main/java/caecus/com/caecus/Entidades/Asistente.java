package caecus.com.caecus.Entidades;

/**
 * Created by Alicia on 15/06/2016.
 */
public class Asistente {
    private String id;
    private String token;
    private String nombre;
    private String apellido;
    private String numero;
    private String mail;
    private String contraseña;

    public Asistente(String id, String token, String nombre, String apellido, String numero, String mail, String contraseña) {

        this.id = id;
        this.token = token;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.mail = mail;
        this.contraseña = contraseña;
    }

    public Asistente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
