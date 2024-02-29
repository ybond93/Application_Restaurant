package miun.dt170g.application_restaurant;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import miun.dt170g.application_restaurant.Adapter.EmpAdapter;
import miun.dt170g.application_restaurant.Adapter.MenuItemAdapter;
import miun.dt170g.application_restaurant.Adapter.TablesAdapter;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.entities.MenuItem;
import miun.dt170g.application_restaurant.entities.Tables;
import miun.dt170g.application_restaurant.retrofit.RetrofitClient;
import miun.dt170g.application_restaurant.retrofit.RetrofitInterface;
import androidx.recyclerview.widget.LinearLayoutManager;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set the LayoutManager

        RetrofitInterface apiData = RetrofitClient.create();
        Call<ArrayList<MenuItem>> menuItemApi = apiData.getMenuItems();

        menuItemApi.enqueue(new Callback<ArrayList<MenuItem>>() {
            @Override
            public void onResponse(Call<ArrayList<MenuItem>> call, Response<ArrayList<MenuItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<MenuItem> menuItemsList = response.body();
                    MenuItemAdapter adapter = new MenuItemAdapter(menuItemsList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("API Error", "Error: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<MenuItem>> call, Throwable t) {
                Log.e("API Error", "Failed to fetch data", t);
            }
        });



            RetrofitInterface data = RetrofitClient.create();
            Call<ArrayList<Tables>> tablesApi = data.getTables();

            tablesApi.enqueue(new Callback<ArrayList<Tables>>() {
                @Override
                public void onResponse(Call<ArrayList<Tables>> call, Response<ArrayList<Tables>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        ArrayList<Tables> tablesList = response.body();
                        TablesAdapter adapter = new TablesAdapter(tablesList); // Declare adapter as a local variable
                        recyclerView.setAdapter(adapter);
                    } else {
                        Log.e("API Error", "Error: " + response.code());
                    }
                }
                @Override
                public void onFailure(Call<ArrayList<Tables>> call, Throwable t) {
                    Log.e("API Error", "Failed to fetch data", t);
                }
            });






        RetrofitInterface apiEMp = RetrofitClient.create();
        Call<ArrayList<Employee>> employeeApi = apiEMp.getEmployees();

        employeeApi.enqueue(new Callback<ArrayList<Employee>>() {
            @Override
            public void onResponse(Call<ArrayList<Employee>> call, Response<ArrayList<Employee>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Employee> employeeList = response.body();
                    EmpAdapter adapter = new EmpAdapter(employeeList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("API Error", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Employee>> call, Throwable t) {
                Log.e("API Error", "Failed to fetch data", t);
            }
        });







    }
}
