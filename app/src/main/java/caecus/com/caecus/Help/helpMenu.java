package caecus.com.caecus.Help;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import caecus.com.caecus.R;
import caecus.com.caecus.RestApi.Adapter.RestApiAdapter;
import caecus.com.caecus.RestApi.EndpointsApi;
import caecus.com.caecus.RestApi.Model.EmparejarResponse;
import caecus.com.caecus.UserSessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class helpMenu extends AppCompatActivity {

    private TextView mensaje;
    private String mLatitudeText;
    private String mLongitudeText;
    private Location lastKnownLocation;
    private double lng;
    private double lat;
    private boolean isWifiCon;
    private String servicioRed;

    private static final String DEBUG_TAG = "NetworkStatus";
    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_menu);
        mensaje = (TextView) findViewById(R.id.lblMsg);

        new CountDownTimer(2000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mensaje.setText("Buscando ayudante");
            }
        }.start();
        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mensaje.setText("Gonzalo es tu ayudante");
            }
        }.start();
        new CountDownTimer(7000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mensaje.setText("Ayuda en progreso");
            }
        }.start();
        new CountDownTimer(20000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mensaje.setText("Fin de la asistencia");
            }
        }.start();
        ConnectivityManager conMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        isWifiCon = networkinfo.isConnected();
        networkinfo = conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileCon = networkinfo.isConnected();

        //networkinfo = conMgr.getNetworkInfo(CONNECTIVITY_SERVICE);
        servicioRed = networkinfo.getSubtypeName();

        Log.d(DEBUG_TAG, "CONECTADO AL WIFI: " + isWifiCon);
        Log.d(DEBUG_TAG, "CONECTADO Datos Moviles: " + isMobileCon);
        Log.d(DEBUG_TAG, "info: " + servicioRed);

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
        lat = lastKnownLocation.getLatitude();
        lng = lastKnownLocation.getLongitude();

        mLatitudeText = String.valueOf(lastKnownLocation.getLatitude());
        mLongitudeText = String.valueOf(lastKnownLocation.getLongitude());

        Log.d("LATITUDE ", mLatitudeText);
        Log.d("LONGITUDE ", mLongitudeText);

        //toqueAyuda();
        session = new UserSessionManager(getApplicationContext());
        crearPeticionAyuda();


    }
    public void crearPeticionAyuda(){
        Map<String, String> jsonBody;
        jsonBody = new HashMap<>();
        //jsonBody.put("PDV_email", session.getUserDetails().get(UserSessionManager.KEY_TOKEN));
        jsonBody.put("email", "maurofernandez@gmail.com");
        jsonBody.put("lat", mLatitudeText);
        jsonBody.put("lng", mLongitudeText);
        if(isWifiCon) jsonBody.put("conex", "WiFi");
        else jsonBody.put("conex", servicioRed);
        RestApiAdapter restApiAdapter = new RestApiAdapter();

        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApi();
        Call<EmparejarResponse> emparejarResponse = endpointsApi.crearPeticionAyuda(jsonBody);
        emparejarResponse.enqueue(new Callback<EmparejarResponse>() {
            @Override
            public void onResponse(Call<EmparejarResponse> call, Response<EmparejarResponse> response) {
                EmparejarResponse emparejarResponse = response.body();
                boolean success = emparejarResponse.isSuccess();
                if (success) {
                    Toast.makeText(getApplicationContext(),
                            "Listo para emparejar",
                            Toast.LENGTH_LONG).show();
                    // Add new Flag to start new Activity
                    //finish();
                    // Intent intent = new Intent(AdmAyudante.this, MenuPDV.class);
                    // AdmAyudante.this.startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(helpMenu.this);
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
            // ResponseInt received from the server
            com.android.volley.ResponseInt.Listener<JSONObject> responseListener = new com.android.volley.ResponseInt.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    VolleyLog.v("ResponseInt: %n %s",response.toString());
                    try {
                        Boolean flag = response.getBoolean("confirmado");
                        if (flag) {
                            Toast.makeText(getApplicationContext(),
                                    "¡Buscando Ayudantes!",
                                    Toast.LENGTH_LONG).show();
                            finish();

                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(helpMenu.this);
                            builder.setMessage("Intente de nuevo")
                                    .setNegativeButton("Reintentar", null)
                                    .create()
                                    .show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            Map<String, String> jsonBody;
            jsonBody = new HashMap<>();
            jsonBody.put("latitud", mLatitudeText);
            jsonBody.put("longitud", mLongitudeText);
            LoginRequest loginRequest = new LoginRequest (jsonBody, responseListener){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Bearer " + session.getUserDetails().get(UserSessionManager.KEY_TOKEN));
                    return headers;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(helpMenu.this);
            queue.add(loginRequest);*/

    }
    public String obtenerDireccion(double lat, double lng){
        String s= "No disponible";
        if (lat != 0.0 && lng != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        lat, lng, 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    s= "Se encuentra en: \n"+DirCalle.getAddressLine(0)+"\n"+DirCalle.getAddressLine(1)+", "+DirCalle.getAddressLine(2);
                }

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return s;

    }

    /*public void toqueAyuda() {

        Log.d("TOQUE_AYUDA", "true");
        String s = obtenerDireccion(lat,lng);
        UsuarioResponse usuarioResponse = new UsuarioResponse("-KMPT9W9n8xBY3CzfYSC", "123", "Juan", mLatitudeText, mLongitudeText);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPoints endPoints = restApiAdapter.establecerConexionRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = endPoints.toqueAyuda(usuarioResponse.getId(), usuarioResponse.getPDV(), usuarioResponse.getLat(), usuarioResponse.getLng());
        usuarioResponseCall.enqueuenew Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, ResponseInt<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body();
                Log.d("ID_F898REBASE", usuarioResponse1.getId());
                Log.d("TOKEN_FIREBASE", usuarioResponse1.getToken());
                Log.d("PDV_FIREBASE", usuarioResponse1.getPDV());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }*/

    public void call(int n) {
        String s = "tel:" + n + "";
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(s));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }
 }
