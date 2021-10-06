package HomeWork.Lesson3.FlowersShop;

public class Rose extends AFlower{
    @Override
    public String getKindFlower() {
        return "Rose";
    }

    public Rose(String color, Sizes size, int freshness, int longFlower, double price) {
        super(longFlower, color, size, freshness, price);
    }

}
