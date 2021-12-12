package homework.ems.menu;

public class SubMenuParty {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n81. Список членов партии. \n" +
                "82. Добавить депутата в партию. \n" +
                "83. Удалить депутата из партии. \n" +
                "84. Выход в основное меню. \n");

    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
