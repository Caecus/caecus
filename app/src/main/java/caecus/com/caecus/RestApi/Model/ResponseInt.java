package caecus.com.caecus.RestApi.Model;

/**
 * Created by USUARIO on 10/09/2016.
 */
public class ResponseInt {
    int mensaje;

    public int getMensaje() {
        return mensaje;
    }

    public void setMensaje(int mensaje) {
        this.mensaje = mensaje;
    }

    public ResponseInt(int mensaje) {

        this.mensaje = mensaje;
    }
}
