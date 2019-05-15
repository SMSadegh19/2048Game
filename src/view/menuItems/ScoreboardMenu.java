package view.menuItems;

import view.commands.commonCommands.ExitCommand;
import view.commands.commonCommands.HelpCommand;
import view.commands.scoreboardCommands.ShowScoreboardCommand;
import view.menuItems.graphicElements.scenes.ScoreboardScene;

import static view.menuItems.MenuConstants.SCOREBOARD_MENU;

public class ScoreboardMenu extends MenuItem {
    @Override
    protected void initMenuItem() {
        name = SCOREBOARD_MENU;

        commands.add(new ShowScoreboardCommand());

        //no sub menu

        scene = ScoreboardScene.makeScene();
    }
}
