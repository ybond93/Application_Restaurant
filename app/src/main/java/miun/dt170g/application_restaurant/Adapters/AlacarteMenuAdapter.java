package miun.dt170g.application_restaurant.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import miun.dt170g.application_restaurant.entities.AlacarteMenuItem;
import miun.dt170g.application_restaurant.R;

public class AlacarteMenuAdapter extends RecyclerView.Adapter<AlacarteMenuAdapter.ViewHolder> {

    private List<AlacarteMenuItem> menuItems;

    public AlacarteMenuAdapter(List<AlacarteMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlacarteMenuItem item = menuItems.get(position);
        holder.itemName.setText(item.getMenuItem().getName());
        holder.itemCategory.setText(item.getCategory());
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName, itemCategory;

        ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.child_item_title);
            itemCategory = itemView.findViewById(R.id.child_item_category);
        }
    }
}
