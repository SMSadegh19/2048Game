package view.commands;

import controllers.InGameController;
import models.Directon;

import java.util.regex.Pattern;

public class MoveCommand extends Command {
    {
        name = "(u|d|l|r)";
        pattern = Pattern.compile("([udrl])", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        String move = matcher.group(1).toLowerCase();
        Directon directon = null;
        switch (move) {
            case "u":
                directon = Directon.UP;
                break;
            case "d":
                directon = Directon.DOWN;
                break;
            case "r":
                directon = Directon.RIGHT;
                break;
            case "l":
                directon = Directon.LEFT;
                break;
        }
        new InGameController().move(directon);
    }
}
