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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import miun.dt170g.application_restaurant.Adapters.EmployeeAdapter;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.retrofit.RetrofitClient;
import miun.dt170g.application_restaurant.retrofit.RetrofitInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitInterface apiData = RetrofitClient.create();
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
    }
}