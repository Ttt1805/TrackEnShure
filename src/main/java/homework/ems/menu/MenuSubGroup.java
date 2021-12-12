package homework.ems.menu;

public class MenuSubGroup {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n7. Работа с избир.участком. \n" +
                "8. Работа с партиями. \n" );

    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
