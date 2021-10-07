package HomeWork.Lesson3.NewYearPresent;

public abstract  class Candy implements ElementPresent{
    protected final String name;
    protected int weight;
    protected int sugarCont;

    public Candy(String name, int weight, int sugarCont) {
        this.name = name;
        this.weight = weight;
        this.sugarCont = sugarCont;
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public int getWeight() {
        return weight;
    }

      public String getName() {
        return name;
    }

    public int getSugarCont() {
        return sugarCont;
    }

    @Override
    public String toString() {
        return "Candy " + getType() + " "+getName() + " {" +
                "weight=" + weight +
                ", sugarCont=" + sugarCont +
                '}';
    }

    public abstract String getType();
}
