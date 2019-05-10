package view.commands.profileCommands;

import controllers.ProfileController;
import view.commands.Command;

import java.util.regex.Pattern;

public class ChangeUsernameCommand extends Command {
    {
        name = "change username to (new name)";
        pattern = Pattern.compile("change username to (\\w+( \\w+)*)",Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        String newName = matcher.group(1);
        new ProfileController().changeUsername(newName);
    }
}
