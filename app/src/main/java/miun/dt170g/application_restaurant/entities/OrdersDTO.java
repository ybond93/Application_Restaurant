package miun.dt170g.application_restaurant.entities;

import java.util.ArrayList;
import java.util.List;

public class OrdersDTO {

    private int orderId;
    private String status;
    private TablesDTO table;

    public OrdersDTO(){};

    public OrdersDTO(int orderId, String status, TablesDTO table) {
        this.orderId = orderId;
        this.status = status;
        this.table = table;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TablesDTO getTable() {
        return table;
    }

    public void setTable(TablesDTO table) {
        this.table = table;
    }
}