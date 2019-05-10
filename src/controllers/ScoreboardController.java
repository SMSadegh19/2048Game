package controllers;

import contracts.ScoreboardContract;
import models.GameContents;
import view.views.ScoreboardView;

public class ScoreboardController implements ScoreboardContract.Controller {
    private ScoreboardContract.View view = new ScoreboardView();

    @Override
    public void loadScoreBoard() {
        view.showScoreboard(GameContents.getProfiles());
    }
}
