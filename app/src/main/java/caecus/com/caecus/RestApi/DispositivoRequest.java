package caecus.com.caecus.RestApi;

/**
 * Created by USUARIO on 19/08/2016.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

public class DispositivoRequest extends JsonObjectRequest {
    private static final String DISPOSITIVO_REQUEST_URL = "http://caecus.pe.hu/Login.php";
    public DispositivoRequest(Map<String, String> payload, Response.Listener<JSONObject> listener) {
        super(Method.POST, DISPOSITIVO_REQUEST_URL, new JSONObject(payload),listener, null);
    }
}
