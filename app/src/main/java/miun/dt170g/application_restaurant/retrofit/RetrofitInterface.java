package miun.dt170g.application_restaurant.retrofit;

import java.util.ArrayList;

import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.entities.Order;
import miun.dt170g.application_restaurant.entities.Table;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @GET("alacartemenuitem")
    Call<ArrayList<AlacarteMenuItem>> getAlacarteMenuItem();

    @GET("employees")
    Call<ArrayList<Employee>> getEmployee();

    @GET("orders")
    Call<ArrayList<Order>> getOrder();

    @GET("tables")
    Call<ArrayList<Table>> getTable();

    @POST("orders")
    Call<Void> sendOrder(@Body Order order);
}
