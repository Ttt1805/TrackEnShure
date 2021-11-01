package homework.ems.menu;

public class MenuElection {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n9. Провести выборы \n");
    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
