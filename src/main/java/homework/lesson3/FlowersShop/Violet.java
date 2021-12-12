package homework.lesson3.FlowersShop;

public class Violet extends AFlower{
    public Violet(String color, Sizes size, int freshness, int longFlower, double price) {
        super(longFlower, color, size, freshness, price);
    }

    public String getKindFlower() {
        return "Violet";
    }

}
