package miun.dt170g.application_restaurant.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import miun.dt170g.application_restaurant.R;
import miun.dt170g.application_restaurant.RecyclerViewInterface;
import miun.dt170g.application_restaurant.Table_list_Activity;
import miun.dt170g.application_restaurant.entities.Employee;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private final Context context;
    private final ArrayList<Employee> employeeList;
    private final RecyclerViewInterface recyclerViewInterface;

    // Constructor: Initializes the adapter with the required parameters
    public EmployeeAdapter(Context context, ArrayList<Employee> employeeList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.employeeList = employeeList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    //Fill the layout for each item in RecyclerView
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_item, parent, false);
        return new EmployeeViewHolder(view, recyclerViewInterface);
    }

    @Override
    //Binds data to the View
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee currentEmployee = employeeList.get(position);
        String fullName = currentEmployee.getFirstName() + " " + currentEmployee.getLastName();
        holder.employeeName.setText(fullName);

        holder.itemView.setOnClickListener(v -> {
            if(recyclerViewInterface != null){
                recyclerViewInterface.onItemClick(position);
            }
        });
    }

    @Override
    //getter
    public int getItemCount() {
        return employeeList.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView employeeName;
        //set onitemclick
        public EmployeeViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            employeeName = itemView.findViewById(R.id.employee_name); // Using simple_list_item_1's TextView
            itemView.setOnClickListener(v -> {
                if (recyclerViewInterface != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            });
        }
    }
}