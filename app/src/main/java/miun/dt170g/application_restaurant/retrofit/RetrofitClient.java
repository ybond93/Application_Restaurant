package miun.dt170g.application_restaurant.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://10.82.241.30:8080/Website-1.0-SNAPSHOT/api/";

    public static RetrofitInterface create() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) // replace with your base URL
                .addConverterFactory(GsonConverterFactory.create()) // for XML support
                .build();
        return retrofit.create(RetrofitInterface.class);
    }
}
