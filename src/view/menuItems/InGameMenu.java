package view.menuItems;

import view.commands.MoveCommand;
import view.commands.StartGameCommand;

import static view.menuItems.MenuConstants.IN_GAME_MENU;

public class InGameMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        // TODO: 5/10/19
        name = IN_GAME_MENU;

        commands.add(new StartGameCommand());
        commands.add(new MoveCommand());

        //no sub menu
    }
}
