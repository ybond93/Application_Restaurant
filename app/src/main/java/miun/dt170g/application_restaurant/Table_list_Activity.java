package miun.dt170g.application_restaurant;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import miun.dt170g.application_restaurant.Adapters.TableListAdapter;

public class Table_list_Activity extends AppCompatActivity implements RecyclerViewInterface{
    private Set<String> activeOrders = new HashSet<>();
    private static final int MENU_ACTIVITY_REQUEST_CODE = 1; // Unique request code


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        RecyclerView recyclerView = findViewById(R.id.tableListRecyclerView); // Ensure you have this RecyclerView in activity_table_list.xml
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> tableNumbers = getTableNumbers();

        TableListAdapter adapter = new TableListAdapter(this, getTableNumbers(), this, activeOrders);
        recyclerView.setAdapter(adapter);


    }

    // Add a method to update the set of active orders
    public void updateActiveOrders(String tableName) {
        activeOrders.add(tableName);
    }

    private List<String> getTableNumbers() {
        return Arrays.asList("Table 1", "Table 2", "Table 3");
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Table_list_Activity.this, MenuActivity.class);
        // Example: Passing the table name to MenuActivity
        String tableName = getTableNumbers().get(position);
        intent.putExtra("tableName", tableName);
        updateActiveOrders(tableName); // Mark this table as having an active order
        startActivity(intent);
    }
}

