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
import java.util.List;
import java.util.Set;

import miun.dt170g.application_restaurant.MenuActivity;
import miun.dt170g.application_restaurant.RecyclerViewInterface;

public class TableListAdapter extends RecyclerView.Adapter<TableListAdapter.TableViewHolder> implements RecyclerViewInterface {

    private final Context context;
    private final List<String> tableList; // Data for your RecyclerView
    private final RecyclerViewInterface recyclerViewInterface;
    private Set<String> activeOrders; // Track tables with active orders

    // Constructor
    public TableListAdapter(Context context, List<String> tableList, RecyclerViewInterface recyclerViewInterface, Set<String> activeOrders) {
        this.context = context;
        this.tableList = tableList;
        this.recyclerViewInterface=recyclerViewInterface;
        this.activeOrders = activeOrders;

    }

    // Method to initialize your ViewHolder
    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new TableViewHolder(view, recyclerViewInterface);
    }

    // Bind data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {
        String currentTable = tableList.get(position);
        holder.tableName.setText(currentTable);

        // Change the background color if the table has an active order
        if (activeOrders.contains(currentTable)) {
            holder.itemView.setBackgroundColor(Color.YELLOW); // Use actual color value or resource
        } else {
            holder.itemView.setBackgroundColor(Color.GREEN); // Reset background color
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MenuActivity.class);
            intent.putExtra("tableName", currentTable);
            context.startActivity(intent);
        });
    }

    // Returns the size of the data set
    @Override
    public int getItemCount() {
        return tableList.size();
    }

    @Override
    public void onItemClick(int position) {

    }

    // ViewHolder class
    public static class TableViewHolder extends RecyclerView.ViewHolder {
        TextView tableName;

        public TableViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            tableName = itemView.findViewById(android.R.id.text1); // Using simple_list_item_1's TextView
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int position= getAdapterPosition();
                        if(position !=RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }

                    }
                }
            });
        }
    }
}
