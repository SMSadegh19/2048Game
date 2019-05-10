package view.commands;

import models.Directon;

import java.util.regex.Pattern;

public class MoveCommand extends Command {
    {
        name = "(up | down | left | right)";
        pattern = Pattern.compile("(up|down|right|left)", Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void doIt() {
        String move = matcher.group(1).toLowerCase();
        Directon directon;
        switch (move) {
            case "up":
                directon = Directon.UP;
                break;
            case "down":
                directon = Directon.DOWN;
                break;
            case "right":
                directon = Directon.RIGHT;
                break;
            case "left":
                directon = Directon.LEFT;
                break;
        }
        // TODO: 5/10/19
    }
}
