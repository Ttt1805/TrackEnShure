package TrackEnShure.HomeWork.Lesson2;

import java.util.Arrays;

public class mmain {
    public static void main(String[] args) {
        Employee[] uEmployees = {new Employee("Vasya",new Teacher()),
                                 new Employee("Petya", new Assistant()),
                                 new Employee("Serega",new Student())};
        for (Employee e: uEmployees) {
            System.out.print(e.getTypeName()+" "+e.getEmployeeName()+" ");
            e.working();
        }
    }
}
