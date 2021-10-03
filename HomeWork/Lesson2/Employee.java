package TrackEnShure.HomeWork.Lesson2;

public class Employee {
    final private String employeeName;
    private Vacansia employeeType;

    Employee(String name, Vacansia e){
        employeeName = name;
        employeeType = e;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void working(){
        employeeType.Working();
    }

    public EmployeeType getType() {
        return employeeType;
    }

    public void setType(Vacansia type) {
        this.employeeType = type;
    }

    String getTypeName(){
        return employeeType.getNameVacansia();
    }
}
