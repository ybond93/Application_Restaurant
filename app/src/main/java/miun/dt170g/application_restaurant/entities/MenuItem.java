package miun.dt170g.application_restaurant.entities;

public class MenuItem {

    private int menuItemId;
    private String name;
    private Double price;
    private String descr;

    public MenuItem(int menuItemId, String name, Double price, String descr) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.price = price;
        this.descr = descr;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
