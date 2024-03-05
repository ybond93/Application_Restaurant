package miun.dt170g.application_restaurant.entities;

import java.util.List;

public class TablesDTO {
    private int tableNum;
    private Boolean status;

    public TablesDTO(){};

    public TablesDTO(int tableNum, Boolean status) {
        this.tableNum = tableNum;
        this.status = status;
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
}