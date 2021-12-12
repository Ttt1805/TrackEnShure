package homework.ems.menu;

public class MenuExit {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n12. Выход \n");
    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
