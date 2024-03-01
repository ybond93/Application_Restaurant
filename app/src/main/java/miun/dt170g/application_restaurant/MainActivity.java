package miun.dt170g.application_restaurant;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import miun.dt170g.application_restaurant.Adapters.EmployeeAdapter;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> employeeNames = getEmployeeNames();
        EmployeeAdapter adapter = new EmployeeAdapter(this, employeeNames, this);
        recyclerView.setAdapter(adapter);
    }

    private List<String> getEmployeeNames() {
        return Arrays.asList("John Doe", "Jane Smith", "Alice Johnson");
    }

    @Override
    public void onItemClick(int position) {
        // You can use the position to get the clicked item from your dataset if needed
        Intent intent = new Intent(MainActivity.this, Table_list_Activity.class);
        startActivity(intent);
    }

}
