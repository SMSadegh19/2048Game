package view.commands;

import java.util.regex.Pattern;

public class StartGameCommand extends Command {
    {
        name = "start game (base number) (number of rows) (number of columns)";
        pattern = Pattern.compile("start game (\\d+) (\\d+) (\\d+)", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        int baseNumber = Integer.parseInt(matcher.group(1));
        int numberOfRows = Integer.parseInt(matcher.group(2));
        int numberOfColumns = Integer.parseInt(matcher.group(3));
        // TODO: 5/10/19
    }
}
