package miun.dt170g.application_restaurant.entities;

public class AlacarteMenuItem {

    private int id;
    private String category;
    private MenuItem menuItem;

    public AlacarteMenuItem(int id, String category, MenuItem menuItem) {
        this.id = id;
        this.category = category;
        this.menuItem = menuItem;
    }

    public int getCarteItemId() {
        return id;
    }

    public void setCarteItemId(int carteItemId) {
        this.id = carteItemId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}