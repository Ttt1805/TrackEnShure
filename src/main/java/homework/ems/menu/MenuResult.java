package homework.ems.menu;

public class MenuResult {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n10. Показать результаты выборов по участку \n"+
                                "11. Показать результаты выборов в целом \n");
    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
