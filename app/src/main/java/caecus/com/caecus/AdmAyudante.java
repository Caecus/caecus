package caecus.com.caecus;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import caecus.com.caecus.RestApi.Adapter.RestApiAdapter;
import caecus.com.caecus.RestApi.EndpointsApi;
import caecus.com.caecus.RestApi.Model.EmparejarResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdmAyudante extends AppCompatActivity {
    private TextView txtCodigo;
    UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_ayudante);
        txtCodigo= (TextView) findViewById(R.id.txtCodigo);
        txtCodigo.setVisibility(View.INVISIBLE);
        int codigo = (int)(Math.random()*8999)+1000;
        txtCodigo.setText(String.valueOf(codigo));
        txtCodigo.setVisibility(View.VISIBLE);
        new CountDownTimer(500, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            txtCodigo.setText(txtCodigo.getText());
        }
        }.start();

        Map<String, String> jsonBody;
        jsonBody = new HashMap<>();
        //jsonBody.put("PDV_email", session.getUserDetails().get(UserSessionManager.KEY_TOKEN));
        jsonBody.put("PDV_email", "maurofernandez@gmail.com");
        jsonBody.put("token", String.valueOf(codigo) );

        RestApiAdapter restApiAdapter = new RestApiAdapter();

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApi();
        Call<EmparejarResponse> emparejarResponse = endpointsApi.onCrearCodigo(jsonBody);
        emparejarResponse.enqueue(new Callback<EmparejarResponse>() {
            @Override
            public void onResponse(Call<EmparejarResponse> call, Response<EmparejarResponse> response) {
                EmparejarResponse emparejarResponse = response.body();
                boolean success = emparejarResponse.isSuccess();
                if (success) {/*
                    Toast.makeText(getApplicationContext(),
                            "Listo para emparejar",
                            Toast.LENGTH_LONG).show();
                    // Add new Flag to start new Activity
                    //finish();
                    // Intent intent = new Intent(AdmAyudante.this, MenuPDV.class);
                    // AdmAyudante.this.startActivity(intent);*/
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdmAyudante.this);
                    builder.setMessage("Error")
                            .setNegativeButton("Reintentar", null)
                            .create()
                            .show();


                }

            }

            @Override
            public void onFailure(Call<EmparejarResponse> call, Throwable t) {

            }
        });




    }
    public void onCrearCodigo(View view) {
        int codigo = (int)(Math.random()*8999)+1000;
        txtCodigo.setText(String.valueOf(codigo));
        txtCodigo.setVisibility(View.VISIBLE);

        Map<String, String> jsonBody;
        jsonBody = new HashMap<>();
        //jsonBody.put("PDV_email", session.getUserDetails().get(UserSessionManager.KEY_TOKEN));
        jsonBody.put("PDV_email", "maurofernandez@gmail.com");
        jsonBody.put("token", String.valueOf(codigo) );

        RestApiAdapter restApiAdapter = new RestApiAdapter();

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApi();
        Call<EmparejarResponse> emparejarResponse = endpointsApi.onCrearCodigo(jsonBody);
        emparejarResponse.enqueue(new Callback<EmparejarResponse>() {
            @Override
            public void onResponse(Call<EmparejarResponse> call, Response<EmparejarResponse> response) {
                EmparejarResponse emparejarResponse = response.body();
                boolean success = emparejarResponse.isSuccess();
                if (success) {/*
                    Toast.makeText(getApplicationContext(),
                            "Listo para emparejar",
                            Toast.LENGTH_LONG).show();
                    // Add new Flag to start new Activity
                    finish();
                   // Intent intent = new Intent(AdmAyudante.this, MenuPDV.class);
                    // AdmAyudante.this.startActivity(intent);*/
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdmAyudante.this);
                    builder.setMessage("Error")
                            .setNegativeButton("Reintentar", null)
                            .create()
                            .show();


                }

            }

            @Override
            public void onFailure(Call<EmparejarResponse> call, Throwable t) {

            }
        });

/*
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";
        String complemento = String.valueOf(codigo);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url + complemento,
                new ResponseInt.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new ResponseInt.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtCodigo.setText("Error!:(");
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + session.getUserDetails().get(UserSessionManager.KEY_TOKEN));
                return headers;
            }
        };
// Add the request to the RequestQueue.
        queue.add(stringRequest);*/




    }
}
