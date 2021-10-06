package HomeWork.Lesson3.NewYearPresent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PresentBox implements ElementPresent{
    List<ElementPresent> box = new ArrayList<>();
    void add(ElementPresent... els){
        for (ElementPresent el:els) {
            box.add(el);
        }
    }

    void remove(ElementPresent... els){
        for (ElementPresent el:els) {
            box.remove(el);
        }

    }

    @Override
    public void show() {
        for (ElementPresent el:box) {
            el.show();
        }

    }

    @Override
    public int getWeight() {
        int totalWeight = 0;
        for (ElementPresent el:box) {
            totalWeight += el.getWeight();
        }

        return totalWeight;
    }

    @Override
    public int getSugarCont() {
        int totalSugarCont = 0;
        for (ElementPresent el:box) {
            totalSugarCont += el.getSugarCont();
        }
        return totalSugarCont;
    }

    ElementPresent findCandy (int minShuga, int maxShuga){
        ElementPresent element = box.stream().filter(el -> ((el.getSugarCont()>=minShuga)&&(el.getSugarCont()<=maxShuga))).findFirst().orElse(null);
        return element;
    }

    void sortedByWeight(){
        PresentBoxSortWeight comparatorWeight = new PresentBoxSortWeight();
        Collections.sort(box,comparatorWeight);
    }
}
