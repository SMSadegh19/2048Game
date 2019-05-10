package view.menuItems;

import view.commands.MoveCommand;
import view.commands.ShowCommand;
import view.commands.StartGameCommand;

import static view.menuItems.MenuConstants.IN_GAME_MENU;

public class InGameMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = IN_GAME_MENU;

        commands.add(new StartGameCommand());
        commands.add(new MoveCommand());
        commands.add(new ShowCommand());

        //no sub menu
    }
}
