package miun.dt170g.application_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import miun.dt170g.application_restaurant.entities.MenuItemOrdersDTO;
import miun.dt170g.application_restaurant.entities.MenuItemsDTO;
import miun.dt170g.application_restaurant.entities.OrdersDTO;
import miun.dt170g.application_restaurant.entities.TablesDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import miun.dt170g.application_restaurant.Adapters.EmployeeAdapter;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.retrofit.RetrofitClient;
import miun.dt170g.application_restaurant.retrofit.RetrofitInterface;
public class MainActivity extends AppCompatActivity {

    // Define RecyclerView and Adapter at the class level to access them in fetchEmployees method
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch employees and set up the adapter in the fetchEmployees method
        fetchEmployees();
    }

    private void fetchEmployees() {
        RetrofitInterface apiData = RetrofitClient.create();


        /*
        // Inserting order(MenuItemOrdersDTO) test
        MenuItemsDTO menuItemsDTO = new MenuItemsDTO(1, "Caesar Salad", 7.99);
        TablesDTO tablesDTO = new TablesDTO(10, "busy");
        OrdersDTO ordersDTO = new OrdersDTO(0,"Idle", tablesDTO);
        MenuItemOrdersDTO menuItemOrdersDTO = new MenuItemOrdersDTO(menuItemsDTO, ordersDTO, 8);


        Call<Void> orderCall = apiData.sendOrder(menuItemOrdersDTO);
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

        Call<ArrayList<Order>> orderApi = apiData.getOrder();
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
        });


        /*Call<ArrayList<Employee>> employeeApi = apiData.getEmployee();
        employeeApi.enqueue(new Callback<ArrayList<Employee>>() {
            @Override
            public void onResponse(Call<ArrayList<Employee>> call, Response<ArrayList<Employee>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Employee> employeeList = response.body();
                    // Initialize and set adapter with fetched employees
                    adapter = new EmployeeAdapter(MainActivity.this, employeeList, new RecyclerViewInterface() {
                        @Override
                        public void onItemClick(int position) {
                            // Implement the action on item click
                            Intent intent = new Intent(MainActivity.this, Table_list_Activity.class);
                            startActivity(intent);
                        }
                    });
                    recyclerView.setAdapter(adapter);
                    Log.e("Success", "Successfully fetched employees: " + response.body().size());
                } else {
                    Log.e("API Error", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Employee>> call, Throwable t) {
                Log.e("API Error", "Failed to fetch data", t);
            }
        });*/
    }
}



