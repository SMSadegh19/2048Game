package view.commands;

import controllers.InGameController;

import java.util.regex.Pattern;

public class ShowCommand extends Command {
    {
        name = "show";
        pattern = Pattern.compile("show", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        new InGameController().loadGameTable();
    }
}
