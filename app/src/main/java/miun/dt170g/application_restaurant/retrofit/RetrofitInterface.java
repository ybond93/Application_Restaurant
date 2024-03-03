package miun.dt170g.application_restaurant.retrofit;

import java.util.ArrayList;

import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.entities.MenuItemOrders;
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
    Call<ArrayList<AlacarteMenuItem>> getAlacarteMenuItem();

    @GET("employees")
    Call<ArrayList<Employee>> getEmployee();

    @GET("orders")
    Call<ArrayList<Order>> getOrder();

    @GET("tables")
    Call<ArrayList<Table>> getTable();

    @POST("orders") //den här för order bara
    Call<Void> sendOrder(@Body Order order);
    @POST("menuitemorders")
    Call<Void> send(@Body MenuItemOrders menuItemOrders);

    @PUT("employees/{empId}")
    Call<Employee> updateEmployee(@Path("empId") int employeeId, @Body Employee employee);



}
