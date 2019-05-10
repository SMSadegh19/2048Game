package view.menuItems;

import view.commands.commonCommands.*;
import view.commands.profileCommands.ChangeUsernameCommand;

import static view.menuItems.MenuConstants.MAIN_MENU;

public class MainMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = MAIN_MENU;

        commands.add(new EnterMenuCommand());
        commands.add(new ChangeUsernameCommand());

        subMenus.add(new InGameMenu());
    }
}
