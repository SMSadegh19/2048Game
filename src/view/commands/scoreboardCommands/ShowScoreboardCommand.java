package view.commands.scoreboardCommands;

import controllers.ScoreboardController;
import view.commands.Command;

import java.util.regex.Pattern;

public class ShowScoreboardCommand extends Command {
    {
        name = "show scoreboard";
        pattern = Pattern.compile("show scoreboard", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        new ScoreboardController().loadScoreBoard();
    }
}
