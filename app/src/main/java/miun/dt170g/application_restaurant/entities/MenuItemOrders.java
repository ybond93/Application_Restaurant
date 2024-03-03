package miun.dt170g.application_restaurant.entities;

public class MenuItemOrders {
    private int itemId;
    /* order id is not needed, as it is
    generated by the server when the order
    is created */
    private int amount;
    private int orderId;

    // Constructors
    public MenuItemOrders(int itemId, int quantity, int orderId) {
        this.itemId = itemId;
        this.amount = quantity;
        this.orderId = orderId;
    }

    // Getters and setters
    public int getMenuItemId() {
        return itemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.itemId = menuItemId;
    }

    public int getQuantity() {
        return amount;
    }

    public void setQuantity(int quantity) {
        this.amount= quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    // toString, equals, and hashCode methods can be overridden as needed
}
