package miun.dt170g.application_restaurant.entities;

public class MenuItemOrdersDTO {
    private MenuItemsDTO menuItem;
    private OrdersDTO order;
    private  int amount;

    public MenuItemOrdersDTO(){};
    public MenuItemOrdersDTO(MenuItemsDTO menuItem, OrdersDTO order, int amount) {
        this.menuItem = menuItem;
        this.order = order;
        this.amount = amount;
    }

    public MenuItemsDTO getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItemsDTO menuItem) {
        this.menuItem = menuItem;
    }

    public OrdersDTO getOrder() {
        return order;
    }

    public void setOrder(OrdersDTO order) {
        this.order = order;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}