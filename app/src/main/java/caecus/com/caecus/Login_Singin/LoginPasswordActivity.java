package caecus.com.caecus.Login_Singin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import caecus.com.caecus.MainActivity;
import caecus.com.caecus.R;
import caecus.com.caecus.RestApi.Adapter.RestApiAdapter;
import caecus.com.caecus.RestApi.EndpointsApi;
import caecus.com.caecus.RestApi.Model.LoginResponse;
import caecus.com.caecus.UserSessionManager;
import caecus.com.caecus.firebase.NotificacionIDTokenService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USUARIO on 03/09/2016.
 */
public class LoginPasswordActivity extends AppCompatActivity {
    UserSessionManager session;
    private TextView pass;
    String tokenFirebase= NotificacionIDTokenService.tokenFirebase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_contrasena);
        pass = (TextView) findViewById(R.id.txtpass);
        session = new UserSessionManager(getApplicationContext());

    }
    public void Login (View view)
    {
        SharedPreferences caecusPreferencias = getSharedPreferences("CaecusPreferencias", 0);
        SharedPreferences.Editor prefEditor = caecusPreferencias.edit();
        prefEditor.putString("password",pass.getText().toString());
        String imei = getIMEI();
        prefEditor.putString("imei",imei);
        prefEditor.putString("pushtoken",tokenFirebase);
        prefEditor.commit();


        Map<String, String> jsonBody;
        jsonBody = new HashMap<>();
        jsonBody.put("email",caecusPreferencias.getString("email",""));
        jsonBody.put("pass",caecusPreferencias.getString("password",""));
        jsonBody.put("imei",imei);
        jsonBody.put("pushtoken.",tokenFirebase);

        RestApiAdapter restApiAdapter = new RestApiAdapter();

        EndpointsApi endpointsApi = restApiAdapter.login();
        Call<LoginResponse> loginResponse = endpointsApi.login(jsonBody);
        loginResponse.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                String token = loginResponse.getToken();
                if (token!=null) {
                    if(loginResponse.getMensaje()==0)
                    {
                        Intent intent1 = new Intent(LoginPasswordActivity.this, NuevoDispositivoActivity.class);
                        LoginPasswordActivity.this.startActivity(intent1);
                    }
                    if(loginResponse.getMensaje()==1)
                    {
                        Intent intent2 = new Intent(LoginPasswordActivity.this, MainActivity.class);
                        startActivity(intent2);
                    }
                } else {



                }
                SharedPreferences caecusPreferencias = getSharedPreferences("CaecusPreferencias", 0);
                SharedPreferences.Editor prefEditor = caecusPreferencias.edit();
                prefEditor.putString("token",token);
                prefEditor.commit();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });


    }
    private String getIMEI() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tm.getDeviceId();
        return imei;
    }

}
