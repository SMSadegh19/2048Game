package view.menuItems;

import view.commands.commonCommands.*;

import static view.menuItems.MenuConstants.MAIN_MENU;

public class MainMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = MAIN_MENU;

        commands.add(new EnterMenuCommand());

        subMenus.add(new InGameMenu());
    }
}
