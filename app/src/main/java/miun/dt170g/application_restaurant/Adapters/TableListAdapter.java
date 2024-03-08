package miun.dt170g.application_restaurant.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import androidx.core.content.ContextCompat; // Make sure to import ContextCompat

import miun.dt170g.application_restaurant.R; // Make sure you import R from your project
import miun.dt170g.application_restaurant.RecyclerViewInterface;
import miun.dt170g.application_restaurant.Table_list_Activity;
import miun.dt170g.application_restaurant.entities.Table;

public class TableListAdapter extends RecyclerView.Adapter<TableListAdapter.TableViewHolder> {

    private final Context context;
    private ArrayList<Table> tableList;
    private final RecyclerViewInterface recyclerViewInterface;
    private final Set<String> activeOrders;

    // Constructor
    public TableListAdapter(Context context, List<Table> tableList, RecyclerViewInterface recyclerViewInterface, Set<String> activeOrders) {
        this.context = context;
        this.tableList = new ArrayList<>(tableList);
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
    //fill the recyclerView
    public TableListAdapter.TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.table_item, parent, false);
        return new TableViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TableListAdapter.TableViewHolder holder, int position) {
        Table currentTable = tableList.get(position);
        String tableDisplay = "Table " + currentTable.getTableNum();
        holder.tableName.setText(tableDisplay);

        // Setting the background color based on the table status using custom colors
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, currentTable.getStatus() ? R.color.red : R.color.green));

        holder.itemView.setOnClickListener(v -> {
            if (recyclerViewInterface != null) {
                recyclerViewInterface.onItemClick(position);
            }
        });
        /*
        holder.itemView.setOnLongClickListener(v -> {
            if (currentTable.getStatus()) {
                // Directly toggle status locally for immediate UI feedback
                currentTable.setStatus(!currentTable.getStatus()); // Assuming you have a setStatus method.

                // Update the color immediately based on the new status
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, currentTable.getStatus() ? R.color.red : R.color.green));
 // Show a toast message based on the new status
            Toast.makeText(context,
                    currentTable.getStatus() ? "Table "+currentTable.getTableNum()+" Occupied" : "Table "+currentTable.getTableNum()+" Available",
                    Toast.LENGTH_SHORT).show();

                // Update the status on the server
                if (context instanceof Table_list_Activity) {
                    ((Table_list_Activity) context).updateTableStatus(currentTable.getTableNum(), currentTable.getStatus());
                }
            }
            return true; // Consume the long click event
        });*/
        holder.itemView.setOnLongClickListener(v -> {
            // Toggle the status locally
            currentTable.setStatus(!currentTable.getStatus());

            // Update the UI immediately to reflect the new status
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context,
                    currentTable.getStatus() ? R.color.red : R.color.green));

            // Show a toast message based on the new status
            Toast.makeText(context,
                    currentTable.getStatus() ? "Table "+currentTable.getTableNum()+" Occupied" : "Table "+currentTable.getTableNum()+" Available",
                    Toast.LENGTH_SHORT).show();

            // Now call the method in your Activity to update the status on the server
            if (context instanceof Table_list_Activity) {
                ((Table_list_Activity) context).updateTableStatus(currentTable.getTableNum(), currentTable.getStatus());
            }

            return true; // Consume the long click event
        });



    }


    @Override
    //getter
    public int getItemCount() {
        return tableList.size();
    }

    //display the table name in TextView
    public static class TableViewHolder extends RecyclerView.ViewHolder {
        TextView tableName;

        public TableViewHolder(@NonNull View itemView) {
            super(itemView);
            tableName = itemView.findViewById(R.id.tableName);
        }
    }


}
