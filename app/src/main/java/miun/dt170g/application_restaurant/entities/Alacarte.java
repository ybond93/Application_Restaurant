package miun.dt170g.application_restaurant.entities;

public class Alacarte {
    private int carteId;
    private int menuId;
    private String category;

    // Constructor
    public Alacarte(int carteId, int menuId, String category) {
        this.carteId = carteId;
        this.menuId = menuId;
        this.category = category;
    }


    public int getCarteId() {
        return carteId;
    }


    public void setCarteId(int carteId) {
        this.carteId = carteId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


