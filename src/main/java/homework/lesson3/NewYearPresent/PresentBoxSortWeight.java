package homework.lesson3.NewYearPresent;

import java.util.Comparator;

public class PresentBoxSortWeight implements Comparator<ElementPresent> {

    @Override
    public int compare(ElementPresent o1, ElementPresent o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
