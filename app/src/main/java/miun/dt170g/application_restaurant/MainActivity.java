package miun.dt170g.application_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

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
        Call<ArrayList<AlacarteMenuItem>> alacarteMenuItemApi = apiData.getAlacarteMenuItem();
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
        });

        Call<ArrayList<Employee>> employeeApi = apiData.getEmployee();
        employeeApi.enqueue(new Callback<ArrayList<Employee>>() {
            @Override
            public void onResponse(Call<ArrayList<Employee>> call, Response<ArrayList<Employee>> response) {

                if (response.isSuccessful() && response.body() != null ) {

                    ArrayList<Employee> employeeList = response.body();
                    Log.e("succ", "succ: " + response.code());

                } else {

                    Log.e("API Error", "Error: " + response.code());
                    Log.e("API Error", "Forbidden: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Employee>> call, Throwable t) {

                Log.e("API Error", "Failed to fetch data", t);
            }
        });

        Call<ArrayList<Table>> tableApi = apiData.getTable();
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
        });

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
    }
}