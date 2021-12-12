package homework.ems.menu;

public class SubMenuPartyStation {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n71. Список избирателей по участку.  \n" +
                "81. Список членов партии.  \n" );

    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
