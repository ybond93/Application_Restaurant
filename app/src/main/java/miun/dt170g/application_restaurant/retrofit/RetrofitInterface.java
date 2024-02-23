package miun.dt170g.application_restaurant.retrofit;

import java.util.ArrayList;

import miun.dt170g.application_restaurant.entities.Event;
import retrofit2.Call;
import retrofit2.http.GET;


public interface RetrofitInterface {
    @GET("events")
    Call<ArrayList<Event>> getEvents();
}
