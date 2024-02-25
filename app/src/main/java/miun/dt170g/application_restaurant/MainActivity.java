package miun.dt170g.application_restaurant;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import miun.dt170g.application_restaurant.Adapter.MenuItemAdapter;
import miun.dt170g.application_restaurant.entities.MenuItem;
import miun.dt170g.application_restaurant.retrofit.RetrofitClient;
import miun.dt170g.application_restaurant.retrofit.RetrofitInterface;
import androidx.recyclerview.widget.RecyclerView;
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
    }
}
