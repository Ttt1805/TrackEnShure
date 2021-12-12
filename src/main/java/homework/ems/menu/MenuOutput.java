package homework.ems.menu;

public class MenuOutput {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n4. Вывести избир.участки. \n" +
                "5. Вывести всех граждан. \n" +
                "6. Вывести все партии. \n" );

    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
