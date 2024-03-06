package miun.dt170g.application_restaurant;

import miun.dt170g.application_restaurant.entities.AlacarteMenuItemsDTO;

public interface OnItemClickListener {
    void onItemClick(AlacarteMenuItemsDTO item, int position);
}
