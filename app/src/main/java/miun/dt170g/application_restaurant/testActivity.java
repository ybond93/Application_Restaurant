package miun.dt170g.application_restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import miun.dt170g.application_restaurant.Adapters.AlacarteMenuAdapter;
import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.retrofit.RetrofitClient;
import miun.dt170g.application_restaurant.retrofit.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class testActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDrinks, recyclerViewMains, recyclerViewStarters, recyclerViewDesserts;
    private TextView headerDrinks, headerMains, headerStarters, headerDesserts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Initialize RecyclerViews and Headers
        initViews();

        // Set click listeners for headers
        setHeaderClickListeners();

        // Set Layout Managers for RecyclerViews
        recyclerViewDrinks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMains.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewStarters.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDesserts.setLayoutManager(new LinearLayoutManager(this));

        RetrofitInterface apiData = RetrofitClient.create();
        Call<ArrayList<AlacarteMenuItem>> alacarteMenuItemApi = apiData.getAlacarteMenuItem();
        alacarteMenuItemApi.enqueue(new Callback<ArrayList<AlacarteMenuItem>>() {
            @Override
            public void onResponse(Call<ArrayList<AlacarteMenuItem>> call, Response<ArrayList<AlacarteMenuItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<AlacarteMenuItem> alacarteMenuItemList = response.body();

                    // Categorize items
                    List<AlacarteMenuItem> drinks = filterItemsByCategory(alacarteMenuItemList, "Drink");
                    List<AlacarteMenuItem> mains = filterItemsByCategory(alacarteMenuItemList, "Main");
                    List<AlacarteMenuItem> starters = filterItemsByCategory(alacarteMenuItemList, "Starter");
                    List<AlacarteMenuItem> desserts = filterItemsByCategory(alacarteMenuItemList, "Dessert");

                    Log.d("CategorySizes", "Drinks: " + drinks.size() + ", Mains: " + mains.size() + ", Starters: " + starters.size() + ", Desserts: " + desserts.size());

                    // Update RecyclerViews
                    updateRecyclerView(recyclerViewDrinks, drinks);
                    updateRecyclerView(recyclerViewMains, mains);
                    updateRecyclerView(recyclerViewStarters, starters);
                    updateRecyclerView(recyclerViewDesserts, desserts);
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

    private void initViews() {
        // Initialize RecyclerViews
        recyclerViewDrinks = findViewById(R.id.recyclerViewDrinks);
        recyclerViewMains = findViewById(R.id.recyclerViewMains);
        recyclerViewStarters = findViewById(R.id.recyclerViewStarters);
        recyclerViewDesserts = findViewById(R.id.recyclerViewDesserts);

        // Initialize Headers
        headerDrinks = findViewById(R.id.headerDrinks);
        headerMains = findViewById(R.id.headerMains);
        headerStarters = findViewById(R.id.headerStarters);
        headerDesserts = findViewById(R.id.headerDesserts);
    }

    private void setHeaderClickListeners() {
        headerDrinks.setOnClickListener(v -> toggleRecyclerViewVisibility(recyclerViewDrinks));
        headerMains.setOnClickListener(v -> toggleRecyclerViewVisibility(recyclerViewMains));
        headerStarters.setOnClickListener(v -> toggleRecyclerViewVisibility(recyclerViewStarters));
        headerDesserts.setOnClickListener(v -> toggleRecyclerViewVisibility(recyclerViewDesserts));
    }

    private void toggleRecyclerViewVisibility(RecyclerView recyclerView) {
        String tag = recyclerView.getTag().toString(); // Ensure you set the tag in your XML or programmatically
        Log.d("ToggleVisibility", tag + " - Current visibility (before): " + (recyclerView.getVisibility() == View.GONE ? "GONE" : "VISIBLE"));
        recyclerView.setVisibility(recyclerView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        Log.d("ToggleVisibility", tag + " - New visibility (after): " + (recyclerView.getVisibility() == View.GONE ? "GONE" : "VISIBLE"));
    }


    private List<AlacarteMenuItem> filterItemsByCategory(List<AlacarteMenuItem> items, String category) {
        return items.stream()
                .filter(item -> category.equals(item.getCategory()))
                .collect(Collectors.toList());
    }

    private void updateRecyclerView(RecyclerView recyclerView, List<AlacarteMenuItem> items) {
        if (items != null && !items.isEmpty()) {
            AlacarteMenuAdapter adapter = new AlacarteMenuAdapter(items);
            recyclerView.setAdapter(adapter);
        } else {
            Log.d("UpdateRecyclerView", "Attempted to update RecyclerView with empty or null data.");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the visibility state of each RecyclerView
        outState.putInt("drinksVisibility", recyclerViewDrinks.getVisibility());
        outState.putInt("mainsVisibility", recyclerViewMains.getVisibility());
        outState.putInt("startersVisibility", recyclerViewStarters.getVisibility());
        outState.putInt("dessertsVisibility", recyclerViewDesserts.getVisibility());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore the visibility state of each RecyclerView
        recyclerViewDrinks.setVisibility(savedInstanceState.getInt("drinksVisibility"));
        recyclerViewMains.setVisibility(savedInstanceState.getInt("mainsVisibility"));
        recyclerViewStarters.setVisibility(savedInstanceState.getInt("startersVisibility"));
        recyclerViewDesserts.setVisibility(savedInstanceState.getInt("dessertsVisibility"));
    }

}
