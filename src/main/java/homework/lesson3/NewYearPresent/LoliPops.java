package homework.lesson3.NewYearPresent;

public class LoliPops extends Candy {
    public LoliPops(String name, int weight, int sugarCont) {
        super(name, weight, sugarCont);
    }

    @Override
    public String getType() {
        return "LoliPops";
    }
}
