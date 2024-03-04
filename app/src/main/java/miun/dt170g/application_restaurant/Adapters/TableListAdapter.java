package miun.dt170g.application_restaurant.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import miun.dt170g.application_restaurant.R; // Make sure you import R from your project
import miun.dt170g.application_restaurant.RecyclerViewInterface;
import miun.dt170g.application_restaurant.Table_list_Activity;
import miun.dt170g.application_restaurant.entities.Table;

public class TableListAdapter extends RecyclerView.Adapter<TableListAdapter.TableViewHolder> {

    private final Context context;
    private ArrayList<Table> tableList; // Use List<Table>
    private final RecyclerViewInterface recyclerViewInterface;
    private final Set<String> activeOrders; // Track tables with active orders

    // Constructor
    // Constructor adjustment
    public TableListAdapter(Context context, List<Table> tableList, RecyclerViewInterface recyclerViewInterface, Set<String> activeOrders) {
        this.context = context;
        this.tableList = new ArrayList<>(tableList); // Adapt here
        this.recyclerViewInterface = recyclerViewInterface;
        this.activeOrders = activeOrders;
    }

    // updateData method adjustment
    public void updateData(List<Table> newTables) {
        this.tableList.clear();
        this.tableList.addAll(newTables);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TableListAdapter.TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableListAdapter.TableViewHolder holder, int position) {
        Table currentTable = tableList.get(position);
        String tableDisplay = "Table " + currentTable.getTableNum(); // Displaying table number
        holder.tableName.setText(tableDisplay);

        // Set initial background color based on active orders
        boolean isActive = activeOrders.contains(String.valueOf(currentTable.getTableNum()));
        holder.itemView.setBackgroundColor(isActive ? Color.YELLOW : Color.TRANSPARENT);

        // Set click listener for the itemView for normal click
        holder.itemView.setOnClickListener(v -> {
            if (recyclerViewInterface != null) {
                recyclerViewInterface.onItemClick(position);
            }
        });

        // Set long click listener for the itemView for status change
        holder.itemView.setOnLongClickListener(v -> {
            // Determine the new status
            String newStatus = currentTable.getStatus().equals("Inactive") ? "Active" : "Inactive";
            currentTable.setStatus(newStatus); // Locally update the status

            // Optionally, call the method to update the status on the server
            if (context instanceof Table_list_Activity) {
                ((Table_list_Activity) context).updateTableStatus(currentTable.getTableNum(), newStatus);
            } else {
                // Update the background color based on the new status
                v.setBackgroundColor(newStatus.equals("Active") ? Color.YELLOW : Color.TRANSPARENT);

                // Optionally, refresh the adapter or perform other UI updates here
                notifyItemChanged(position);
            }

            return true; // Indicate that the callback consumed the long click
        });
    }



    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public static class TableViewHolder extends RecyclerView.ViewHolder {
        TextView tableName;

        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            tableName = itemView.findViewById(android.R.id.text1);
        }
    }


}
