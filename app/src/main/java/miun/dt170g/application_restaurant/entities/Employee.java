package miun.dt170g.application_restaurant.entities;

public class Employee {

    private int empIp;

    private String fName;

    private String lName;

    private String jobTitle;

    public Employee(int empIp, String fName, String lName, String jobTitle) {
        this.empIp = empIp;
        this.fName = fName;
        this.lName = lName;
        this.jobTitle = jobTitle;
    }

    public int getEmpIp() {
        return empIp;
    }

    public void setEmpIp(int empIp) {
        this.empIp = empIp;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
