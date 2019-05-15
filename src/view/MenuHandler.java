package view;

import javafx.stage.Stage;
import view.menuItems.InGameMenu;
import view.menuItems.MenuItem;
import view.menuItems.ProfileMenu;

import static view.MenuChangingState.*;
import static view.Notify.*;

public class MenuHandler {
    private static Stage stage;
    private static MenuItem currentMenu = null;

    public static void setStage(Stage stage) {
        MenuHandler.stage = stage;
    }

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
        if (state != AT_FIRST_ENTER) {
            stage.setScene(currentMenu.getScene());
        }
        if (state == TOP_TO_DOWN || state == AT_FIRST_ENTER) {
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
        startMenu(new ProfileMenu(), AT_FIRST_ENTER);
    }
}
