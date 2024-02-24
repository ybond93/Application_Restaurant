package miun.dt170g.application_restaurant.entities;

public class MenuItem {

    private int menuItemId;

    private String name;

    private Double price;

    private String type;

    private String descr;

    private String category;

    public MenuItem(int menuItemId, String name, Double price, String type, String descr, String category) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.price = price;
        this.type = type;
        this.descr = descr;
        this.category = category;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
