package view.menuItems;

import view.commands.profileCommands.CreateProfileCommand;
import view.commands.profileCommands.LoginCommand;

import static view.menuItems.MenuConstants.PROFILE_MENU;

public class ProfileMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = PROFILE_MENU;

        commands.add(new CreateProfileCommand());
        commands.add(new LoginCommand());

        subMenus.add(new MainMenu());
        subMenus.add(new ScoreboardMenu());
    }
}
