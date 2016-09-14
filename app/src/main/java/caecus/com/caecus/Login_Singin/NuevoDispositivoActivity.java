package caecus.com.caecus.Login_Singin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import caecus.com.caecus.R;
import caecus.com.caecus.RestApi.Adapter.RestApiAdapter;
import caecus.com.caecus.RestApi.EndpointsApi;
import caecus.com.caecus.RestApi.Model.ResponseInt;
import caecus.com.caecus.UserSessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USUARIO on 19/08/2016.
 */
public class NuevoDispositivoActivity extends AppCompatActivity {
    UserSessionManager session;
    private TextView telefono;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_dispositivo);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");


        telefono=(TextView) findViewById(R.id.txttelefono);
        session = new UserSessionManager(getApplicationContext());
    }
    public void crearDispositivo (View view)    {
        final String tel = telefono.toString();
        SharedPreferences caecusPreferencias = getSharedPreferences("CaecusPreferencias", 0);
        if(tel.trim().length() > 0 ) {
            Map<String, String> jsonBody;
            jsonBody = new HashMap<>();
            jsonBody.put("imei", caecusPreferencias.getString("imei","") );
            jsonBody.put("telefono",tel);

            RestApiAdapter restApiAdapter = new RestApiAdapter();

            EndpointsApi endpointsApi = restApiAdapter.login();
            Call<ResponseInt> registrarResponse = endpointsApi.registrarDispositivo(jsonBody);
            registrarResponse.enqueue(new Callback<ResponseInt>() {
                @Override
                public void onResponse(Call<ResponseInt> call, Response<ResponseInt> response) {
                    ResponseInt registrarResponse = response.body();
                    int msj = registrarResponse.getMensaje();
                    if (msj>0) {
                        if(registrarResponse.getMensaje()==0)
                        {

                        }
                        if(registrarResponse.getMensaje()==1)
                        {

                        }
                    } else {



                    }
                    SharedPreferences caecusPreferencias = getSharedPreferences("CaecusPreferencias", 0);
                    SharedPreferences.Editor prefEditor = caecusPreferencias.edit();
                    prefEditor.putString("token",token);
                    prefEditor.commit();
                }

                @Override
                public void onFailure(Call<ResponseInt> call, Throwable t) {

                }
            });
        }
        else{
            // user didn't entered tel
            Toast.makeText(getApplicationContext(),
                    "Ingrese teléfono",
                    Toast.LENGTH_LONG).show();
        }
    }

}
