package HomeWork.Lesson3.FlowersShop;

public class Lilia extends AFlower{
    public Lilia(String color, Sizes size, int freshness, int longFlower, double price) {
        super(longFlower, color, size, freshness,  price);
    }

    public String getKindFlower() {
        return "Lilia";
    }


}
