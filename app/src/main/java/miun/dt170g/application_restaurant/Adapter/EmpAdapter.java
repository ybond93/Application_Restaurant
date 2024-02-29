package miun.dt170g.application_restaurant.Adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import miun.dt170g.application_restaurant.entities.Employee;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import miun.dt170g.application_restaurant.R;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder> {
    private ArrayList<Employee> employeeList;

    public EmpAdapter(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.nameTextView.setText(employee.getfName() + " " + employee.getlName());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.employeeName);
        }
    }
}
