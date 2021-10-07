package HomeWork.Lesson3.FlowersShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateBouquet implements  ElemBouquet{
    private List<ElemBouquet> bouquet = new ArrayList<>();

    @Override
    public double getPrice() {
        double sum = 0;
        for (ElemBouquet el : bouquet) {
            sum += el.getPrice();
        }
        return sum;
    }

    @Override
    public String getType() {
        return "bouquet";
    }

    @Override
    public void show() {
        for (ElemBouquet el:bouquet) {
            el.show();
        }

    }

    public void add (ElemBouquet ... els){
        Collections.addAll(bouquet, els);
    }

    public void remove (ElemBouquet ... els){
        for (ElemBouquet el : els) {
            bouquet.remove(el);
        }
    }

    public void sortByFreshness(){
        BouquetSortFreshness freshnessComp = new BouquetSortFreshness();
        bouquet.sort(freshnessComp);
    }

    public ElemBouquet FindFlowers(int minLong, int maxLong){
        ElemBouquet fl = null;
        for (ElemBouquet el : bouquet) {
            if (el.getType().equals("flower")) {
                int longFl = ((AFlower) el).getLengthFlower();
                if (longFl >= minLong && longFl <= maxLong)
                {
                    fl = el;
                    break;
                }
            }
        }
        return fl;
    }

}
