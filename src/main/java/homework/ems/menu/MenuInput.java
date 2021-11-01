package homework.ems.menu;

public class MenuInput {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n1. Добавить участок. \n" +
                "2. Добавить гражданина. \n" +
                "3. Добавить партию. \n" );

    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
