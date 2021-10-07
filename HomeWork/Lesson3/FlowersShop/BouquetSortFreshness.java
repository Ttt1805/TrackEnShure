package HomeWork.Lesson3.FlowersShop;

import java.util.Comparator;

public class BouquetSortFreshness implements Comparator<ElemBouquet> {
    @Override
    public int compare(ElemBouquet o1, ElemBouquet o2) {
        int fr1 = o1.getType().equals("accessory") ? 0 : ((AFlower)o1).getFreshness();
        int fr2 = o2.getType().equals("accessory") ? 0 : ((AFlower)o2).getFreshness();
        return fr2 - fr1;
    }
}
