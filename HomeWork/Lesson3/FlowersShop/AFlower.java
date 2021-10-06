package HomeWork.Lesson3.FlowersShop;


public abstract class AFlower implements ElemBouquet{
    protected final String color;

    protected int longFlower;
    protected Sizes size;
    protected int freshness;
    protected double price;


    public AFlower(int longFlower, String color, Sizes size, int freshness, double price) {
        this.longFlower = longFlower;
        this.color = color;
        this.size = size;
        this.freshness = freshness;
        this.price = price;
    }


    public int getLongFlower() {
        return longFlower;
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

    public void setLongFlower(int longFlower) {
        this.longFlower = longFlower;
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

        return getKindFlower()+"{" +
                "color='" + color + '\'' +
                ", size=" + size +
                ", long=" + longFlower +
                ", freshness=" + freshness +"%"+
                ", price=" + price +
                '}';
    }
}
