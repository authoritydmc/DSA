package DSA.API_CALL;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static  Retrofit retrofit ;

    public static Retrofit getClient()
    {
//        SINGLETON STRUCTURE


        if (retrofit==null)
        {
              OkHttpClient.Builder httpClient=new OkHttpClient.Builder();

            retrofit =new Retrofit.Builder().
                baseUrl("https://fakerapi.it/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        }
        return retrofit;
    }



}
