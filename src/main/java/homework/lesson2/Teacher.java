package homework.lesson2;

public class Teacher extends Vacansia {

    Teacher(){
        setNameVacansia("Преподаватель");
    }

    @Override
    public void Working() {
        System.out.println("читает лекцию");
    }
}
