package miun.dt170g.application_restaurant.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import miun.dt170g.application_restaurant.R;
import miun.dt170g.application_restaurant.entities.Tables;

public class TablesAdapter extends RecyclerView.Adapter<TablesAdapter.ViewHolder> {
        private ArrayList<Tables> tablesList;

        public TablesAdapter(ArrayList<Tables> tablesList) {
            this.tablesList = tablesList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_menu, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Tables table = tablesList.get(position);
            holder.tablesNumTextView.setText( table.getTablesNum());
            holder.statusTextView.setText(table.getStatus());
        }

        @Override
        public int getItemCount() {
            return tablesList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tablesNumTextView, statusTextView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tablesNumTextView = itemView.findViewById(R.id.tableNumber);
                statusTextView = itemView.findViewById(R.id.tableStatus);
            }
        }
    }
