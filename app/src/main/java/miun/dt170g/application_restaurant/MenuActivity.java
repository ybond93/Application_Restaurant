package miun.dt170g.application_restaurant;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import miun.dt170g.application_restaurant.Adapters.OrdersAdapter;
import miun.dt170g.application_restaurant.Adapters.ParentItemAdapter;
import miun.dt170g.application_restaurant.entities.CategoryItem;
import miun.dt170g.application_restaurant.entities.OrderItem;
import miun.dt170g.application_restaurant.entities.SubItem;

public class MenuActivity extends AppCompatActivity implements ParentItemAdapter.OnSubItemClickListener {

    private RecyclerView parentRecyclerView, ordersRecyclerView;
    private ParentItemAdapter parentItemAdapter;
    private List<CategoryItem> categoryItemList;
    private List<OrderItem> ordersList = new ArrayList<>();
    private OrdersAdapter ordersAdapter;
    private String tableName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Retrieve the table name from the Intent
        tableName = getIntent().getStringExtra("tableName");

        // Initialize the Orders RecyclerView and its Adapter with the tableName
        ordersRecyclerView = findViewById(R.id.orders_recyclerView);
        ordersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ordersAdapter = new OrdersAdapter(ordersList, tableName); // Correctly pass the tableName here
        ordersRecyclerView.setAdapter(ordersAdapter);

        // Initialize and set up the Category (Parent) RecyclerView and its Adapter
        categoryItemList = new ArrayList<>();
        prepareMenuData();
        parentItemAdapter = new ParentItemAdapter(categoryItemList, this);
        parentRecyclerView = findViewById(R.id.parent_recyclerView);
        parentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        parentRecyclerView.setAdapter(parentItemAdapter);
    }


    @Override
    public void onSubItemClick(SubItem subItem) {
        // Check if the item already exists in the orders list
        boolean itemExists = false;
        for (OrderItem orderItem : ordersList) {
            if (orderItem.getItemName().equals(subItem.getSubItemName())) {
                // If the item exists, increase its quantity
                orderItem.setQuantity(orderItem.getQuantity() + 1);
                itemExists = true;
                break;
            }
        }

        // If the item does not exist in the list, add it with a quantity of 1
        if (!itemExists) {
            ordersList.add(new OrderItem(subItem.getSubItemName(), 1));
        }

        ordersAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Added to order: " + subItem.getSubItemName(), Toast.LENGTH_SHORT).show();
    }
    // Method in MenuActivity to update the table name
    public void updateTableName(String newTableName) {
        if (ordersAdapter != null) {
            ordersAdapter.updateTableName(newTableName);
            Toast.makeText(this, "Table changed to: " + newTableName, Toast.LENGTH_SHORT).show();
        }
    }

    private void prepareMenuData() {
        categoryItemList.add(new CategoryItem("Drinks", Arrays.asList(new SubItem("Coke"), new SubItem("Water"))));
        categoryItemList.add(new CategoryItem("Förrätter", Arrays.asList(new SubItem("Soup"), new SubItem("Salad"))));
        categoryItemList.add(new CategoryItem("Huvudrätter", Arrays.asList(new SubItem("Steak"), new SubItem("Pasta"))));
        categoryItemList.add(new CategoryItem("Efterrätter", Arrays.asList(new SubItem("Ice Cream"), new SubItem("Cake"))));
    }
}
