package miun.dt170g.application_restaurant.retrofit;

import java.util.ArrayList;

import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.entities.AlacarteMenuItemsDTO;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.entities.MenuItemOrdersDTO;
import miun.dt170g.application_restaurant.entities.Order;
import miun.dt170g.application_restaurant.entities.Table;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @GET("alacartemenuitem")
    Call<ArrayList<AlacarteMenuItemsDTO>> getAlacarteMenuItem();

    @GET("employees")
    Call<ArrayList<Employee>> getEmployee();

    @GET("orders")
    Call<ArrayList<Order>> getOrder();

    @GET("menuitemorder")
    Call<ArrayList<MenuItemOrdersDTO>> getMenuItemOrdersDTO();

    @POST("menuitemorder")
    Call<MenuItemOrdersDTO> addTableOrder(@Body MenuItemOrdersDTO mio_dto);

    @GET("tables")
    Call<ArrayList<Table>> getTable();

    @PUT("tables/{tableNum}")
    Call<Table> updateTableStatus(@Path("tableNum") int tableNum, @Body Table table);
}
