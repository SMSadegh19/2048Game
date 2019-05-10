package controllers;

import contracts.InGameContract;
import models.GameContents;
import models.Table;
import view.views.InGameView;

public class InGameController implements InGameContract.Controller {
    private InGameContract.View view;

    public InGameController() {
        view = new InGameView();
        view.setController(this);
    }

    @Override
    public void loadGameTable() {
        Table gameTable = GameContents.getCurrentGame();
        if (gameTable == null) {
            // TODO: 5/10/19
        } else {
            view.showGameTable(GameContents.getCurrentGame());
        }
    }

    @Override
    public void startGame(int baseNumber, int numberOfRows, int numberOfColumns) {
        // TODO: 5/10/19
    }
}
