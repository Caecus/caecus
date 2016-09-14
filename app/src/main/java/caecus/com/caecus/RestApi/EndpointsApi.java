package caecus.com.caecus.RestApi;

import java.util.Map;

import caecus.com.caecus.RestApi.Model.EmparejarResponse;
import caecus.com.caecus.RestApi.Model.LoginResponse;
import caecus.com.caecus.RestApi.Model.ResponseInt;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
/**
 * Created by USUARIO on 30/08/2016.
 */
public interface EndpointsApi {
    /*@Headers( "Content-Type: application/json" )
    @POST(ConstantesRestApi.LOGIN)
    Call<LoginResponse> login(@Body Map<String, String> body);*/

    @Headers({ "Content-Type: application/json" })
    @POST(ConstantesRestApi.TOKEN_EMPAREJAR)
    Call<EmparejarResponse> onCrearCodigo(@Body Map<String, String> body);

    @Headers( "Content-Type: application/json" )
    @POST(ConstantesRestApi.lOGIN)
    Call<LoginResponse> login(@Body Map<String, String> body);

    @Headers({ "Content-Type: application/json",
    "token: 123123123123123"})
    @POST(ConstantesRestApi.PETICION_AYUDA)
    Call<EmparejarResponse> crearPeticionAyuda(@Body Map<String, String> body);

    @Headers({ "Content-Type: application/json" })
    @POST(ConstantesRestApi.REGISTRAR_DISPOSITIVO)
    Call<ResponseInt> registrarDispositivo(@Body Map<String, String> body);




}
