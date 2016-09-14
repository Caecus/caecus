package caecus.com.caecus.RestApi.Model;

/**
 * Created by USUARIO on 09/09/2016.
 */
public class LoginResponse {
    String token;
    int mensaje;
    public LoginResponse(){

    }

    public LoginResponse(boolean success, int mensaje) {
        this.token = token;
        this.mensaje = mensaje;
    }

    public String getToken() {
        return token;
    }

    public int getMensaje() {
        return mensaje;
    }

    public void setMensaje(int mensaje) {
        this.mensaje = mensaje;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
