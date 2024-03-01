package miun.dt170g.application_restaurant.entities;
import java.util.List;

public class CategoryItem {
    private String categoryName;
    private List<SubItem> subItemList;

    public CategoryItem(String categoryName, List<SubItem> subItemList) {
        this.categoryName = categoryName;
        this.subItemList = subItemList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<SubItem> getSubItemList() {
        return subItemList;
    }
}
