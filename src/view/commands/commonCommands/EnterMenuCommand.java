package view.commands.commonCommands;

import view.MenuHandler;
import view.commands.Command;

import java.util.regex.Pattern;

public class EnterMenuCommand extends Command {
    {
        name = "Enter (menu name)";
        pattern = Pattern.compile("enter (\\w+( \\w+)*)", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        String menuName = matcher.group(1);
        MenuHandler.goToSubMenu(menuName);
    }
}
