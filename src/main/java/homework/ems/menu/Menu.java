package homework.ems.menu;

public class Menu {
//    private boolean isFullMenu;

    public StringBuilder getMenu() {
        return menu;
    }

    public void setMenu(StringBuilder menu) {
        this.menu = menu;
    }

    private StringBuilder menu;

    public Menu() {
    }

//    public boolean isFullMenu() {
//        return isFullMenu;
//    }
//
//    public void setFullMenu(boolean fullMenu) {
//        isFullMenu = fullMenu;
//    }

    public void createMenu(boolean isFullMenu) {
        StringBuilder newMenu = new StringBuilder();
        if (isFullMenu) {
            newMenu.append(MenuInput.getMenu())
                    .append(MenuOutput.getMenu())
                    .append(MenuSubGroup.getMenu())
                    .append(MenuElection.getMenu())
                    .append(MenuResult.getMenu())
                    .append(MenuExit.getMenu());
        }else {
            newMenu.append(MenuOutput.getMenu())
                    .append(SubMenuPartyStation.getMenu())
                    .append(MenuResult.getMenu())
                    .append(MenuExit.getMenu());
        }
        setMenu(newMenu);
    }

    public void showMenu() {
        System.out.println(menu);
        System.out.print("Выберите пункт меню: ");
    }
}
