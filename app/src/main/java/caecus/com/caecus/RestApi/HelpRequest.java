package caecus.com.caecus.RestApi;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by USUARIO on 07/01/2016.
 */
public class HelpRequest extends JsonObjectRequest {
        private static final String HELP_REQUEST_URL = "http://caecus.pe.hu/Login.php";
        public HelpRequest(Map<String, String> payload, Response.Listener<JSONObject> listener) {
            super(Method.POST, HELP_REQUEST_URL, new JSONObject(payload),listener, null);
        }
}

