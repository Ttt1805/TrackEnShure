package HomeWork.Lesson2;

public class Student extends Vacansia {

    Student(){
       setNameVacansia("Cтудент");
    }

    @Override
    public void Working() {
        System.out.println("cлушает лекцию");
    }
}
