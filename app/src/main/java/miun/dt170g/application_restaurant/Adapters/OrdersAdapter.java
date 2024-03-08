package miun.dt170g.application_restaurant.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import miun.dt170g.application_restaurant.R;
import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.entities.AlacarteMenuItemsDTO;
import miun.dt170g.application_restaurant.entities.MenuItemOrdersDTO;
import miun.dt170g.application_restaurant.entities.MenuItemsDTO;
import miun.dt170g.application_restaurant.entities.OrdersDTO;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MenuItemOrderViewHolder> {

    private final List<MenuItemOrdersDTO> menuItemOrdersList;
    private final LayoutInflater inflater;
    private List<AlacarteMenuItemsDTO> allMenuItems; // List to hold all menu items


    public OrdersAdapter(Context context, List<MenuItemOrdersDTO> menuItemOrdersList) {
        this.inflater = LayoutInflater.from(context);
        this.menuItemOrdersList = menuItemOrdersList;
    }

    @NonNull
    @Override
    public MenuItemOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.order_item, parent, false);
        return new MenuItemOrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemOrderViewHolder holder, int position) {
        MenuItemOrdersDTO currentOrder = menuItemOrdersList.get(position);
        MenuItemsDTO menuItem = currentOrder.getMenuItem();
        OrdersDTO order = currentOrder.getOrder();

        holder.menuItemNameTextView.setText(menuItem.getName());
        holder.menuItemAmountTextView.setText(String.format("Amount: %d",currentOrder.getAmount()));
        holder.menuItemPriceTextView.setText(String.format("$%.2f", menuItem.getPrice()));
        holder.orderIdTextView.setText(String.format("Order ID: %d", order.getOrderId()));
        // Additional fields can be set here if required
    }

    @Override
    public int getItemCount() {
        return menuItemOrdersList.size();
    }

    static class MenuItemOrderViewHolder extends RecyclerView.ViewHolder {
        TextView menuItemNameTextView, menuItemAmountTextView, menuItemPriceTextView, orderIdTextView;

        public MenuItemOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            menuItemNameTextView = itemView.findViewById(R.id.order_item_name);
            menuItemAmountTextView = itemView.findViewById(R.id.order_item_quantity);
            menuItemPriceTextView = itemView.findViewById(R.id.menuItemPriceTextView);
            orderIdTextView = itemView.findViewById(R.id.orderIdTextView);

        }
    }

    // Optionally, you can include methods to update the dataset e.g., add, remove, update items
    public void updateOrders(List<MenuItemOrdersDTO> newOrders) {
        this.menuItemOrdersList.clear();
        this.menuItemOrdersList.addAll(newOrders);
        notifyDataSetChanged();
    }
    public void setAllMenuItems(List<AlacarteMenuItemsDTO> allMenuItems) {
        this.allMenuItems = allMenuItems;
    }
    private String getMenuItemNameById(int id) {
        for (AlacarteMenuItemsDTO item : allMenuItems) {
            if (item.getCarteItemId() == id) {
                return item.getMenuItemName();
            }
        }
        Log.d("OrdersAdapter", "Item not found for ID: " + id); // Debugging line
        return "Unknown Item"; // Fallback in case the item ID is not found
    }

}
