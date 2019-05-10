package view;

import view.menuItems.MenuItem;
import view.menuItems.ProfilesMenu;

import static view.MenuChangingState.*;
import static view.Notify.*;

public class MenuHandler {
    private static MenuItem currentMenu = null;

    public static MenuItem getCurrentMenu() {
        return currentMenu;
    }

    public static void goToSubMenu(String subMenuName) {
        for (MenuItem subMenu : currentMenu.getSubMenus()) {
            if (subMenu.getName().equalsIgnoreCase(subMenuName)) {
                startMenu(subMenu, TOP_TO_DOWN);
                return;
            }
        }
        logError("This subMenu doesn't exist.");
    }

    public static void goToParentMenu() {
        if (currentMenu.getParentMenu() == null) {
            System.exit(0);
        } else {
            startMenu(currentMenu.getParentMenu(), DOWN_TO_TOP);
        }
    }

    private static void startMenu(MenuItem menuItem, MenuChangingState state) {
        MenuItem tempParent = currentMenu;
        currentMenu = menuItem;
        if (state == TOP_TO_DOWN) {
            menuItem.setParentMenu(tempParent);
        }

        showCurrentMenu();
    }

    public static void showCurrentMenu() {
        logMessage("Current menu: " + "\"" + currentMenu.getName() + "\"");
        if (currentMenu.getSubMenus().size() != 0) {
            logMessage("Sub menus:");
        }
        for (MenuItem subMenu : currentMenu.getSubMenus()) {
            logMessage("\t* " + subMenu.getName());
        }
    }

    public static void startFirstMenu() {
//       todo new AccountController().loadAccounts();
        startMenu(new ProfilesMenu(), TOP_TO_DOWN);
    }
}
