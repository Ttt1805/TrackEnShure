package HomeWork.Lesson3.FlowersShop;

import java.sql.SQLOutput;

public class Accessory implements ElemBouquet {
    private double price;
    private String name;

    public Accessory( String name, double price) {
        this.price = price;
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return "accessory";
    }

    @Override
    public void show() {
        System.out.println(name + "{" + price + "}");
    }

}
