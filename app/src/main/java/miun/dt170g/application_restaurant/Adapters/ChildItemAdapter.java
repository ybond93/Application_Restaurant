package miun.dt170g.application_restaurant.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import miun.dt170g.application_restaurant.entities.SubItem;
import miun.dt170g.application_restaurant.R;

public class ChildItemAdapter extends RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder> {

    private List<SubItem> subItemList;
    private OnItemClickListener onItemClickListener;

    // Modified constructor to include OnItemClickListener
    public ChildItemAdapter(List<SubItem> subItemList, OnItemClickListener onItemClickListener) {
        this.subItemList = subItemList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        SubItem subItem = subItemList.get(position);
        holder.childItemTitle.setText(subItem.getSubItemName());

        // Set onClickListener to each itemView
        holder.itemView.setOnClickListener(v -> {
            if(onItemClickListener != null) {
                onItemClickListener.onItemClick(subItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subItemList.size();
    }

    // ViewHolder class for child items
    static class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView childItemTitle;

        ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            childItemTitle = itemView.findViewById(R.id.child_item_title);
        }
    }

    // Interface for click events
    public interface OnItemClickListener {
        void onItemClick(SubItem item);
    }
}