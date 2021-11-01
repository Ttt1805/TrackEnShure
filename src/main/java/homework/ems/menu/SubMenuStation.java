package homework.ems.menu;

public class SubMenuStation {
    final static StringBuilder menu;
    static {
        menu=new StringBuilder("\n71. Список избирателей по участку. \n" +
                "72. Добавить избирателя в участок. \n" +
                "73. Удалить избирателя из участка. \n" +
                "74. Выход в основное меню. \n");

    }

    public static StringBuilder getMenu() {
        return menu;
    }

    public void showMenuInput() {
        System.out.println(menu);
    }

}
