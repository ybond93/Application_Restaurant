package miun.dt170g.application_restaurant.entities;

public class MenuItemOrdersDTO {
    private MenuItemsDTO itemId;
    private OrdersDTO orderId;
    private  int amount;

    public void setOrderId(OrdersDTO orderId) {
        this.orderId = orderId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setItemId(MenuItemsDTO itemId) {
        this.itemId = itemId;
    }

    public OrdersDTO getOrderId() {
        return orderId;
    }

    public int getAmount() {
        return amount;
    }

    public MenuItemsDTO getItemId() {
        return itemId;
    }
}
