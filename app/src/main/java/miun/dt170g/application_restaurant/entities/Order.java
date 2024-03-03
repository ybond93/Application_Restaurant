package miun.dt170g.application_restaurant.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;
    private int tableNum;
    private List<MenuItemOrders> menuItemOrders = new ArrayList<>();

    // Initialize the list in the constructor or elsewhere before adding items
    public Order() {
        menuItemOrders = new ArrayList<>();
    }

    public void setMenuItemOrders(List<MenuItemOrders> menuItemOrders) {
        this.menuItemOrders = menuItemOrders;
    }

    // Method to add a menu item order to the list
    public void addMenuItemOrder(MenuItemOrders menuItemOrder) {
        menuItemOrders.add(menuItemOrder);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

}
