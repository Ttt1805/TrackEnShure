package HomeWork.Lesson3.NewYearPresent;

public class Chocolat extends Candy {
    public Chocolat(String name, int weight, int sugarCont) {
        super(name, weight, sugarCont);
    }

    @Override
    public String getType() {
        return "Chocolate";
    }


}
