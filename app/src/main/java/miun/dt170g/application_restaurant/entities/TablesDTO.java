package miun.dt170g.application_restaurant.entities;

import java.util.List;

public class TablesDTO {
    private int tableNum;
    private String status;

    public TablesDTO(){};

    public TablesDTO(int tableNum, String status) {
        this.tableNum = tableNum;
        this.status = status;
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
}