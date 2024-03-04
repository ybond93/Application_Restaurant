package miun.dt170g.application_restaurant.entities;

import java.util.ArrayList;
import java.util.List;

public class OrdersDTO {

    private int orderId;
    private TablesDTO tableNum;
    private List<MenuItemOrdersDTO> menuItemsOrders;



    public TablesDTO getTableNum() {return  tableNum;}

    public OrdersDTO(int orderId, TablesDTO tableNum, List<MenuItemOrdersDTO> menuItemsOrders) {
        this.orderId = orderId;
        this.tableNum = tableNum;
        this.menuItemsOrders = menuItemsOrders;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTableNum(TablesDTO tableNum) {
        this.tableNum = tableNum;
    }

    public List<MenuItemOrdersDTO> getMenuItemsOrders() {
        return menuItemsOrders;
    }

    public void setMenuItemsOrders(List<MenuItemOrdersDTO> menuItemsOrders) {
        this.menuItemsOrders = menuItemsOrders;
    }
}