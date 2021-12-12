package homework.lesson8;

public class Car {
    private int id;
    private String model;
    private int year;
    private double price;
    private String vinCode;

    public Car() {
    }

    public int getId() {
        return id;
    }

    public Car(int id, String model, int year, double price, String vinCode) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.vinCode = vinCode;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", vinCode='" + vinCode + '\'' +
                '}';
    }
}
