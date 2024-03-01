package miun.dt170g.application_restaurant.Adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import miun.dt170g.application_restaurant.RecyclerViewInterface;
import miun.dt170g.application_restaurant.Table_list_Activity;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> implements RecyclerViewInterface{

    private final Context context;
    private final List<String> employeeList; // This will be the data for your RecyclerView
    private final RecyclerViewInterface recyclerViewInterface;

    // Constructor
    public EmployeeAdapter(Context context, List<String> employeeList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.employeeList = employeeList;
        this.recyclerViewInterface= recyclerViewInterface;

    }

    // This method is called right when the adapter is created and is used to initialize your ViewHolder
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new EmployeeViewHolder(view, recyclerViewInterface);
    }

    // This method is called many times to bind the data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        String currentEmployee = employeeList.get(position);
        holder.employeeName.setText(currentEmployee);
        holder.itemView.setOnClickListener(v -> {
            // When an employee name is clicked, start the Table_list_Activity and pass the employee name to it
            Intent intent = new Intent(context, Table_list_Activity.class);
            intent.putExtra("employeeName", currentEmployee);
            context.startActivity(intent);
        });

    }

    // This method returns the size of the collection that contains the items we want to display
    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    @Override
    public void onItemClick(int position) {

    }

    // The ViewHolder describes an item view and metadata about its place within the RecyclerView
    public static class EmployeeViewHolder extends RecyclerView.ViewHolder  {
        TextView employeeName;

        public EmployeeViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            employeeName = itemView.findViewById(android.R.id.text1); // simple_list_item_1 has a TextView with id @android:id/text1
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
