package HomeWork.Lesson3.NewYearPresent;

public class Mmain {
    public static void main(String[] args) {
        ElementPresent sw1 = new Chocolat("Mars",100,30);
        ElementPresent sw2 = new Chocolat("Snikers",100,40);
        ElementPresent sw3 = new Caramel("Korovka",20,12);
        ElementPresent sw4 = new LoliPops("Pops",30,18);

        PresentBox smallBox = new PresentBox();
        smallBox.add(sw1, sw2, sw3, sw4);
        smallBox.show();
        System.out.println("Total = " + smallBox.getWeight());

        System.out.print("Find candy: ");
        ElementPresent el = smallBox.findCandy(10,15);
        if (el != null){
            el.show();
        }
        smallBox.sortedByWeight();
        smallBox.show();
    }
}
