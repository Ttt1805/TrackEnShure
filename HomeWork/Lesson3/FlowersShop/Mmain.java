package HomeWork.Lesson3.FlowersShop;

import java.util.Arrays;

public class Mmain {
    public static void main(String[] args) {
        ElemBouquet rose1 = new Rose("red",Sizes.BIG,80,50, 35);
        ElemBouquet rose2 = new Rose("white",Sizes.BIG,90,50, 35);
        ElemBouquet rose3 = new Rose("white",Sizes.SMALL,100,30, 30);
        ElemBouquet rose4 = new Rose("red",Sizes.MEDIUM,90,40, 30);
        ElemBouquet rose5 = new Rose("black red",Sizes.MEDIUM,100,50, 50);

        ElemBouquet lilia1 = new Lilia("white",Sizes.MEDIUM,100,50, 35);
        ElemBouquet lilia2 = new Lilia("yellow",Sizes.MEDIUM,50,50, 35);
        ElemBouquet lilia3 = new Lilia("yellow",Sizes.MEDIUM,70,50, 35);

        ElemBouquet violet1 = new Violet("blue",Sizes.MEDIUM,70,30, 20);
        ElemBouquet violet2 = new Violet("cian",Sizes.MEDIUM,60,40, 20);
        ElemBouquet violet3 = new Violet("navy blue",Sizes.MEDIUM,80,30, 20);

        ElemBouquet tulip1 = new Tulip("red",Sizes.MEDIUM,70,30, 15);
        ElemBouquet tulip2 = new Tulip("yellow",Sizes.MEDIUM,70,30, 15);
        ElemBouquet tulip3 = new Tulip("white",Sizes.MEDIUM,80,30, 15);

        ElemBouquet acc1 = new Accessory("tape", 15);
        ElemBouquet acc2 = new Accessory("bow", 20);
        ElemBouquet acc3 = new Accessory("paper", 10);


        CreateBouquet bouquet = new CreateBouquet();
        bouquet.add(rose1, rose2, rose3, lilia1, rose4, acc1, acc2,acc3);
        bouquet.show();
        System.out.println("Total = " + bouquet.getPrice());

/*        CreateBouquet bouquet2 = new CreateBouquet();
        bouquet2.add(lilia2, lilia3, violet1, violet2, violet3, acc1, acc2,acc3);

        bouquet2.show();
        System.out.println("Total = " + bouquet2.getPrice());
*/
        bouquet.sortByFreshness();
        bouquet.show();

        ElemBouquet fl = bouquet.FindFlowers(40, 60);
        if (fl != null) {
            fl.show();
        }
    }
}
