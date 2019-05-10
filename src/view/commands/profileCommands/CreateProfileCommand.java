package view.commands.profileCommands;

import controllers.ProfileController;
import view.commands.Command;

import java.util.regex.Pattern;

public class CreateProfileCommand extends Command {
    {
        name = "create profile (name) (password)";
        pattern = Pattern.compile("create profile (\\w+( \\w+)*) (\\w+( \\w+)*)", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        String name = matcher.group(1);
        String password = matcher.group(3);
        new ProfileController().createProfile(name, password);
    }
}
