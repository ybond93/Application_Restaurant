package miun.dt170g.application_restaurant.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import miun.dt170g.application_restaurant.entities.CategoryItem;
import miun.dt170g.application_restaurant.entities.SubItem;
import miun.dt170g.application_restaurant.R;

public class ParentItemAdapter extends RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder> {

    private List<CategoryItem> itemList;
    private OnSubItemClickListener subItemClickListener; // Callback interface

    // Constructor modified to accept OnSubItemClickListener
    public ParentItemAdapter(List<CategoryItem> itemList, OnSubItemClickListener subItemClickListener) {
        this.itemList = itemList;
        this.subItemClickListener = subItemClickListener;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        CategoryItem item = itemList.get(position);
        holder.parentItemTitle.setText(item.getCategoryName());
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.childRecyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        holder.childRecyclerView.setLayoutManager(layoutManager);

        // Pass the subItemClickListener to the ChildItemAdapter
        ChildItemAdapter childItemAdapter = new ChildItemAdapter(item.getSubItemList(), subItem -> {
            if (subItemClickListener != null) {
                subItemClickListener.onSubItemClick(subItem);
            }
        });
        holder.childRecyclerView.setAdapter(childItemAdapter);

        // Handle expand/collapse functionality
        holder.parentItemTitle.setOnClickListener(view -> {
            if (holder.childRecyclerView.getVisibility() == View.VISIBLE) {
                holder.childRecyclerView.setVisibility(View.GONE);
            } else {
                holder.childRecyclerView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ParentViewHolder extends RecyclerView.ViewHolder {
        TextView parentItemTitle;
        RecyclerView childRecyclerView;

        ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            parentItemTitle = itemView.findViewById(R.id.parent_item_title);
            childRecyclerView = itemView.findViewById(R.id.child_recyclerView);
        }
    }

    // Interface for handling clicks on SubItems
    public interface OnSubItemClickListener {
        void onSubItemClick(SubItem subItem);
    }
}
