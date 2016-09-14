package caecus.com.caecus.RestApi.Model;

/**
 * Created by USUARIO on 09/09/2016.
 */
public class RegistarDispositivoResponse {
    int respuesta;
    public RegistarDispositivoResponse(int respuesta) {
        this.respuesta = respuesta;
    }
    public RegistarDispositivoResponse(){}
    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }


}
