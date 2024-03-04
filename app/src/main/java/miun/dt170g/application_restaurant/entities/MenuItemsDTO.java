package miun.dt170g.application_restaurant.entities;

public class MenuItemsDTO {
    private int id;
    private String name;
    private Double price;
    private String descr;
    // Consider if you need a list of MenuItemOrdersDTO depending on your use case

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getDescr() {
        return descr;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    // Constructors, Getters, and Setters
}
