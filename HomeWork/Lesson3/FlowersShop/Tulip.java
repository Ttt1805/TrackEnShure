package HomeWork.Lesson3.FlowersShop;

public class Tulip extends AFlower{
    public Tulip(String color, Sizes size, int freshness, int longFlower, double price) {
        super(longFlower, color, size, freshness,price);
    }

    public String getKindFlower() {
        return "Tulip";
    }

}
