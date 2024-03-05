package miun.dt170g.application_restaurant.entities;

import java.util.List;

public class Order {

    private int orderId;
    private int tableNum;
    private List<MenuItemQuantityDTO> menuItemQuantities;

    public static class MenuItemQuantityDTO {
        private int menuItemId;
        private int amount;

        public MenuItemQuantityDTO(int menuItemId, int amount) {
            this.menuItemId = menuItemId;
            this.amount = amount;
        }

        public int getMenuItemId() {
            return menuItemId;
        }

        public void setMenuItemId(int menuItemId) {
            this.menuItemId = menuItemId;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
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

    public List<MenuItemQuantityDTO> getMenuItemQuantities() {
        return menuItemQuantities;
    }

    public void setMenuItemQuantities(List<MenuItemQuantityDTO> menuItemQuantities) {
        this.menuItemQuantities = menuItemQuantities;
    }
}