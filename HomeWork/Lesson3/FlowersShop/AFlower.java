package HomeWork.Lesson3.FlowersShop;


public abstract class AFlower implements ElemBouquet{
    protected final String color;

    protected int lengthFlower;
    protected Sizes size;
    protected int freshness;
    protected double price;


    public AFlower(int lengthFlower, String color, Sizes size, int freshness, double price) {
        this.lengthFlower = lengthFlower;
        this.color = color;
        this.size = size;
        this.freshness = freshness;
        this.price = price;
    }


    public int getLengthFlower() {
        return lengthFlower;
    }

    public String getColor() {
        return color;
    }

    public Sizes getSize() {
        return size;
    }

    public int getFreshness() {
        return freshness;
    }

    public abstract String getKindFlower();

    public void setLengthFlower(int lengthFlower) {
        this.lengthFlower = lengthFlower;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }

     public void setPrice(double price) {
        this.price=price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return "flower";
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        return getKindFlower() + "{" +
                "color='" + color + '\'' +
                ", size=" + size +
                ", long=" + lengthFlower +
                ", freshness=" + freshness + "%" +
                ", price=" + price +
                '}';
    }
}
