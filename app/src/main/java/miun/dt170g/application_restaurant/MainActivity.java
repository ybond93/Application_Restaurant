package miun.dt170g.application_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.entities.Order;
import miun.dt170g.application_restaurant.entities.Table;
import miun.dt170g.application_restaurant.retrofit.RetrofitClient;
import miun.dt170g.application_restaurant.retrofit.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitInterface apiData = RetrofitClient.create();

        Employee updateEmp = new Employee(1,"Julian", "Nordin");
        /*List<Order.MenuItemQuantityDTO> menuItemQuantities = new ArrayList<>();
        newOrder.setOrderId(0);
        newOrder.setTableNum(10);
        menuItemQuantities.add(new Order.MenuItemQuantityDTO(4, 2));
        menuItemQuantities.add(new Order.MenuItemQuantityDTO(8, 5));*/

        /*Call<ArrayList<AlacarteMenuItem>> alacarteMenuItemApi = apiData.getAlacarteMenuItem();
        alacarteMenuItemApi.enqueue(new Callback<ArrayList<AlacarteMenuItem>>() {
            @Override
            public void onResponse(Call<ArrayList<AlacarteMenuItem>> call, Response<ArrayList<AlacarteMenuItem>> response) {

                if (response.isSuccessful() && response.body() != null ) {

                    ArrayList<AlacarteMenuItem> alacarteMenuItemList = response.body();
                    Log.e("succ", "succ: " + response.code());

                } else {

                    Log.e("API Error", "Error: " + response.code());
                    Log.e("API Error", "Forbidden: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<AlacarteMenuItem>> call, Throwable t) {

                Log.e("API Error", "Failed to fetch data", t);
            }
        });*/

        //List<Integer> tt =  new ArrayList<>();
        //Table temp = new Table(5, "In Progress",tt);
        /*Call<Table> call = apiData.updateTableStatus(5, temp);
        call.enqueue(new Callback<Table>() {
            @Override
            public void onResponse(Call<Table> call, Response<Table> response) {
                if (response.isSuccessful()) {
                    Table updatedTable = response.body();
                } else {
                }
            }
            @Override
            public void onFailure(Call<Table> call, Throwable t) {
                t.printStackTrace();
            }
        });*/

        //Call<Employee> call = apiData.updateEmployee(1, updateEmp);
        /*call.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if (response.isSuccessful()) {
                    // Employee updated successfully
                    Employee updatedEmployee = response.body();
                    // Handle the updated employee object
                } else {
                    // Handle HTTP error response
                    // For example, response.code(), response.errorBody(), etc.
                }
            }
            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                // Handle failure
                t.printStackTrace();
            }
        });*/


        /*Call<ArrayList<Table>> tableApi = apiData.getTable();
        tableApi.enqueue(new Callback<ArrayList<Table>>() {
            @Override
            public void onResponse(Call<ArrayList<Table>> call, Response<ArrayList<Table>> response) {

                if (response.isSuccessful() && response.body() != null ) {

                    ArrayList<Table> tableList = response.body();
                    Log.e("succ", "succ: " + response.code());

                } else {

                    Log.e("API Error", "Error: " + response.code());
                    Log.e("API Error", "Forbidden: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Table>> call, Throwable t) {

                Log.e("API Error", "Failed to fetch data", t);
            }
        });*/

        // Set menu item quantities for the order
        //newOrder.setMenuItemQuantities(menuItemQuantities);

        /*Call<Void> orderCall = apiData.sendOrder(newOrder);
        orderCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Handle successful response
                    Log.e("Success", "order sent successfully");
                } else {
                    // Handle unsuccessful response
                    Log.e("API Error", "Error code: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Handle failure
                Log.e("API Error", "Failed to send order", t);
            }
        });*/

        /*Call<ArrayList<Order>> orderApi = apiData.getOrder();
        orderApi.enqueue(new Callback<ArrayList<Order>>() {
            @Override
            public void onResponse(Call<ArrayList<Order>> call, Response<ArrayList<Order>> response) {

                if (response.isSuccessful() && response.body() != null ) {

                    ArrayList<Order> orderList = response.body();
                    Log.e("succ", "succ: " + response.code());

                } else {

                    Log.e("API Error", "Error: " + response.code());
                    Log.e("API Error", "Forbidden: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Order>> call, Throwable t) {

                Log.e("API Error", "Failed to fetch data", t);
            }
        });*/
    }
}