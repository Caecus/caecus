package caecus.com.caecus.RestApi;

/**
 * Created by USUARIO on 19/08/2016.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

public class LoginRequest extends JsonObjectRequest {
    private static final String LOGIN_REQUEST_URL = "http://caecus.pe.hu/Login.php";
    public LoginRequest(Map<String, String> payload, Response.Listener<JSONObject> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, new JSONObject(payload),listener, null);
    }





}