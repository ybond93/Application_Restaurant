package miun.dt170g.application_restaurant.entities;

import java.util.List;

public class TablesDTO {
    private int tableNum;
    private String Status;
    private List<OrdersDTO> orders;



    public int getTableNum() {
        return tableNum;
    }


    public String getStatus() {
        return Status;
    }

    public void setOrders(List<OrdersDTO> orders) {
        this.orders = orders;
    }

    public List<OrdersDTO> getOrders() {
        return orders;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }
}