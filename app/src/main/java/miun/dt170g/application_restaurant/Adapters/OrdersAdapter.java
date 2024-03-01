package miun.dt170g.application_restaurant.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import miun.dt170g.application_restaurant.entities.OrderItem;
import miun.dt170g.application_restaurant.R;


public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {

    private List<OrderItem> orderList;
    private String tableName; // Add a field for the table name


    public OrdersAdapter(List<OrderItem> orderList, String tableName) {
        this.orderList = orderList;
        this.tableName = tableName;
    }
    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }
    // Method in OrdersAdapter to update the table name and refresh display
    public void updateTableName(String newTableName) {
        this.tableName = newTableName;
        notifyItemChanged(0); // Assuming the first item displays the table name
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        if (position == 0) {
            // Assuming you have a way to display the table name in the first item
            // You might need a special view type for this
            holder.orderItemName.setText("Table: " + tableName);
            holder.orderItemQuantity.setText(""); // Clear quantity for table display
        } else {
            OrderItem item = orderList.get(position - 1); // Adjust index for table display
            holder.orderItemName.setText(item.getItemName());
            holder.orderItemQuantity.setText(String.valueOf(item.getQuantity()));
        }
    }

    @Override
    public int getItemCount() {
        return orderList.size() + 1; // +1 for the table display
    }
    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView orderItemName, orderItemQuantity;

        OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderItemName = itemView.findViewById(R.id.order_item_name);
            orderItemQuantity = itemView.findViewById(R.id.order_item_quantity);
        }
    }
}
