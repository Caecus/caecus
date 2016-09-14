package caecus.com.caecus.RestApi;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by USUARIO on 09/09/2016.
 */
public class RegistrarDispositivoRequest extends JsonObjectRequest {
    private static final String REG_DISPOSITIVO_REQUEST_URL = "http://caecus.pe.hu/Login.php";
    public RegistrarDispositivoRequest(Map<String, String> payload, Response.Listener<JSONObject> listener) {
        super(Method.POST, REG_DISPOSITIVO_REQUEST_URL, new JSONObject(payload),listener, null);
    }
}