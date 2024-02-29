package miun.dt170g.application_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.entities.Employee;
import miun.dt170g.application_restaurant.entities.Event;
import miun.dt170g.application_restaurant.entities.MenuItem;
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
    }
}

/*
RetrofitInterface apiData = RetrofitClient.create();
        Call<ArrayList<Event>> eventApi = apiData.getEvents();
        eventApi.enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {

                if (response.isSuccessful() && response.body() != null ) {

                    ArrayList<Event> eventsList = response.body();
                    Log.e("succ", "succ: " + response.code());

                } else {

                    Log.e("API Error", "Error: " + response.code());
                    Log.e("API Error", "Forbidden: " + response.message());
                }
            }


            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {

                Log.e("API Error", "Failed to fetch data", t);
            }
        });
*/