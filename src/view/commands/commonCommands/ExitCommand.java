package view.commands.commonCommands;

import view.MenuHandler;
import view.commands.Command;

import java.util.regex.Pattern;

public class ExitCommand extends Command {
    {
        name = "exit";
        pattern = Pattern.compile("exit", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        MenuHandler.goToParentMenu();
    }
}
