package view.commands.profileCommands;

import controllers.ProfileController;
import view.commands.Command;

import java.util.regex.Pattern;

public class LoginCommand extends Command {
    {
        name = "login (name) (password)";
        pattern = Pattern.compile("login (\\w+( \\w+)*) (\\w+( \\w+)*)", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        String name = matcher.group(1);
        String password = matcher.group(3);
        new ProfileController().login(name, password);
    }
}
