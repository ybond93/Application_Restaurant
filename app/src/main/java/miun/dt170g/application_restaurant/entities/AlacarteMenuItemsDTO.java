package miun.dt170g.application_restaurant.entities;

public class AlacarteMenuItemsDTO {
    private int carteItemId;
    private String category;
    private String menuItemName;
    public AlacarteMenuItemsDTO (){};
    public AlacarteMenuItemsDTO(int carteItemId, String category, String menuItemName) {
        this.carteItemId = carteItemId;
        this.category = category;
        this.menuItemName = menuItemName;
    }

    public int getCarteItemId() {
        return carteItemId;
    }

    public void setCarteItemId(int carteItemId) {
        this.carteItemId = carteItemId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }
}
