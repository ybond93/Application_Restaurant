package miun.dt170g.application_restaurant.retrofit;

import java.util.ArrayList;

import miun.dt170g.application_restaurant.entities.Alacarte;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.entities.Event;
import miun.dt170g.application_restaurant.entities.MenuItem;
import miun.dt170g.application_restaurant.entities.Tables;
import retrofit2.Call;
import retrofit2.http.GET;



public interface RetrofitInterface {
    @GET("events")
    Call<ArrayList<Event>> getEvents();

    @GET("employees")
    Call<ArrayList<Employee>> getEmployees();

    @GET("menuitems")
    Call<ArrayList<MenuItem>> getMenuItems();

    @GET("tables")
    Call<ArrayList<Tables>> getTables();
}
