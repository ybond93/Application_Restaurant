package miun.dt170g.application_restaurant.entities;

import java.util.List;

public class Table {
    private int tableNum;
    private Boolean status;
    private List<Integer> orderIds;

    public Table(int tableNum, Boolean status, List<Integer> orderIds) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Integer> orderIds) {
        this.orderIds = orderIds;
    }
}