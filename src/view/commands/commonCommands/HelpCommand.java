package view.commands.commonCommands;

import view.MenuHandler;
import view.commands.Command;

import java.util.regex.Pattern;

import static view.Notify.logMessage;

public class HelpCommand extends Command {
    {
        name = "help";
        pattern = Pattern.compile("help", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        logMessage("Current menu: " + "\"" + MenuHandler.getCurrentMenu().getName() + "\"");
        logMessage("Commands of this menu:");
        for (Command command : MenuHandler.getCurrentMenu().getCommands()) {
            logMessage("\t* " + command.getName());
        }
    }
}
