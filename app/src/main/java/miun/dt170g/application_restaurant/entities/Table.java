package miun.dt170g.application_restaurant.entities;

import java.util.List;

public class Table {
    private int tableNum;
    private String status;
    private List<Integer> orderIds;

    public Table(int tableNum, String status, List<Integer> orderIds) {
        this.tableNum = tableNum;
        this.status = status;
        this.orderIds = orderIds;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }
}
