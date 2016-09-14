package caecus.com.caecus.RestApi.Adapter;
import caecus.com.caecus.RestApi.ConstantesRestApi;
import caecus.com.caecus.RestApi.EndpointsApi;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        return retrofit.create(EndpointsApi.class);
    }
    public EndpointsApi login(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        return retrofit.create(EndpointsApi.class);
    }

}