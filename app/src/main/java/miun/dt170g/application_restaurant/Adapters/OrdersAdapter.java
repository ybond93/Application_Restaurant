package miun.dt170g.application_restaurant.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import miun.dt170g.application_restaurant.entities.MenuItemOrdersDTO;
import miun.dt170g.application_restaurant.R;
import android.content.Context;

import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {

    private List<MenuItemOrdersDTO> orderList;
    private List<AlacarteMenuItem> allMenuItems; // List to hold all menu items
    private LayoutInflater inflater;

    public OrdersAdapter(Context context, List<MenuItemOrdersDTO> orderList, List<AlacarteMenuItem> allMenuItems) {
        this.inflater = LayoutInflater.from(context);
        this.orderList = orderList;
        this.allMenuItems = allMenuItems; // Initialize with the provided list
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        MenuItemOrdersDTO currentOrder = orderList.get(position);
        holder.tableNumberTextView.setText("Table: " + currentOrder.getOrder().getTable().getTableNum());
        StringBuilder menuItemsText = new StringBuilder();

        /*for (MenuItemOrdersDTO item : currentOrder.getOrderId().getMenuItemsOrders()) {
            String itemName = getMenuItemNameById(item.getItemId().getId());

            menuItemsText.append(itemName).append(" x ").append(item.getAmount()).append("\n");
        }
        holder.menuItemsTextView.setText(menuItemsText.toString().trim());*/
    }

    /**
     * This class is needed whenever new data is fetched
     * through @GET. Once we have the new data, we should
     * call this method from the "onResponse" method
     * @param newMenuItems
     */
    public void updateMenuItems(List<AlacarteMenuItem> newMenuItems) {
        this.allMenuItems.clear();
        this.allMenuItems.addAll(newMenuItems);
        notifyDataSetChanged(); // Only if you want to refresh the whole adapter, might not be necessary
    }
    public void setAllMenuItems(List<AlacarteMenuItem> allMenuItems) {
        this.allMenuItems = allMenuItems;
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView tableNumberTextView, menuItemsTextView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tableNumberTextView = itemView.findViewById(R.id.tableNumberTextView);
            menuItemsTextView = itemView.findViewById(R.id.order_item_name);
        }
    }
    public void updateOrders(List<MenuItemOrdersDTO> newOrders) {
        this.orderList.clear();
        this.orderList.addAll(newOrders);
        notifyDataSetChanged();
    }
    private String getMenuItemNameById(int id) {
        for (AlacarteMenuItem item : allMenuItems) {
            if (item.getMenuItem().getMenuItemId() == id) {
                return item.getMenuItem().getName();
            }
        }
        Log.d("OrdersAdapter", "Item not found for ID: " + id); // Debugging line
        return "Unknown Item"; // Fallback in case the item ID is not found
    }

}
