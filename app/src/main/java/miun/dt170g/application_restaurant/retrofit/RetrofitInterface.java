package miun.dt170g.application_restaurant.retrofit;

import java.util.ArrayList;

import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.entities.MenuItemOrdersDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @GET("alacartemenuitem")
    Call<ArrayList<AlacarteMenuItem>> getAlacarteMenuItem();

    @GET("employees")
    Call<ArrayList<Employee>> getEmployee();

    @GET("tables")
    Call<ArrayList<Table>> getTable();

    @GET("menuitemorders")
    Call<ArrayList<MenuItemOrdersDTO>> getMenuItemOrdersDTO();

    @GET("orders")
    Call<ArrayList<Order>> getOrder();

    @PUT("tables/{tableNum}")
    Call<Table> updateTableStatus(@Path("tableNum") int tableNum, @Body Table table);

    @POST("menuitemorder")
    Call<Void> sendOrder(@Body MenuItemOrdersDTO MenuItemOrder);
}
