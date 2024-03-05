package miun.dt170g.application_restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import miun.dt170g.application_restaurant.Adapters.TableListAdapter;
import miun.dt170g.application_restaurant.retrofit.RetrofitClient;
import miun.dt170g.application_restaurant.retrofit.RetrofitInterface;

public class Table_list_Activity extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private TableListAdapter adapter;
    private Set<String> activeOrders = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list); // Ensure you have a corresponding layout

        recyclerView = findViewById(R.id.tableListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchTables();
    }

    private void fetchTables() {
        RetrofitInterface apiService = RetrofitClient.create();
        Call<ArrayList<Table>> call = apiService.getTable(); // Assuming getTable() is correctly implemented in your Retrofit interface

        call.enqueue(new Callback<ArrayList<Table>>() {
            @Override
            public void onResponse(Call<ArrayList<Table>> call, Response<ArrayList<Table>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Table> tables = response.body();
                    // Initialize and set adapter with fetched tables
                    adapter = new TableListAdapter(Table_list_Activity.this, tables, position -> {
                        // First, update the table status
                        //updateTableStatus(tables.get(position).getTableNum());


                        // Then, navigate to MenuActivity with the table number
                        // Replace testActivity.class with MenuActivity.class if that's the actual class you meant
                        Intent intent = new Intent(Table_list_Activity.this, testActivity.class);
                        intent.putExtra("tableNumber", tables.get(position).getTableNum());
                        startActivity(intent);
                    }, activeOrders);
                    recyclerView.setAdapter(adapter);
                    Log.e("Success", "Successfully fetched tables: " + tables.size());
                } else {
                    Log.e("API Error", "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Table>> call, Throwable t) {
                Log.e("API Error", "Failed to fetch data", t);
            }
        });
    }
    /*private void updateTableStatus(int tableNumber) {
        List<Integer> tt = new ArrayList<>(); // Assuming tt is needed for your logic
        Table temp = new Table(tableNumber, "In Progress", tt); // Adjust the Table constructor as per your actual Table class

        RetrofitInterface apiData = RetrofitClient.create();
        Call<Table> call = apiData.updateTableStatus(tableNumber, temp);
        call.enqueue(new Callback<Table>() {
            @Override
            public void onResponse(Call<Table> call, Response<Table> response) {
                if (response.isSuccessful()) {
                    Table updatedTable = response.body();
                    Log.d("UpdateTable", "Table updated successfully: " + updatedTable.getTableNum());
                    fetchTables(); // Re-fetch tables to reflect the updated status
                } else {
                    Log.e("UpdateTableError", "Error updating table: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<Table> call, Throwable t) {
                Log.e("UpdateTableFailure", "Failed to update table", t);
            }
        });
    }*/
    public void updateTableStatus(int tableNumber, String newStatus) {
        List<Integer> tt = new ArrayList<>(); // Adjust as needed for your API
        Table temp = new Table(tableNumber, newStatus, tt); // Adjust constructor as needed

        RetrofitInterface apiData = RetrofitClient.create();
        Call<Table> call = apiData.updateTableStatus(tableNumber, temp);
        call.enqueue(new Callback<Table>() {
            @Override
            public void onResponse(Call<Table> call, Response<Table> response) {
                if (response.isSuccessful()) {
                    Log.d("UpdateTableStatus", "Status updated successfully for table: " + tableNumber);
                    fetchTables(); // Re-fetch to sync with server
                } else {
                    Log.e("UpdateTableError", "Error updating table status: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Table> call, Throwable t) {
                Log.e("UpdateTableFailure", "Failed to update table status", t);
            }
        });
    }


    // Optional: Update activeOrders if your logic requires
    // Add a method to update the set of active orders
    public void updateActiveOrders(String tableName) {
        activeOrders.add(tableName);
    }

    private List<String> getTableNumbers() {
        return Arrays.asList("Table 1", "Table 2", "Table 3");
    }

    /*
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Table_list_Activity.this, MenuActivity.class);
        // Example: Passing the table name to MenuActivity
        String tableName = getTableNumbers().get(position);
        intent.putExtra("tableName", tableName);
        updateActiveOrders(tableName); // Mark this table as having an active order
        startActivity(intent);
    }

     */

}
