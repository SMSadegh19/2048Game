package controllers;

import contracts.InGameContract;
import models.Directon;
import models.GameContents;
import models.Table;
import view.Notify;
import view.menuItems.graphicElements.sceneMakers.InGameSceneMaker;
import view.views.InGameView;

public class InGameController implements InGameContract.Controller {
    private InGameContract.View view;

    public InGameController() {
        view = new InGameView();
    }

    @Override
    public void loadGameTable() {
        Table gameTable = GameContents.getCurrentGame();
        if (gameTable == null) {
        } else {
            InGameSceneMaker.updateScene(gameTable);
            view.showGameTable(GameContents.getCurrentGame());
        }
    }

    @Override
    public void startGame(int baseNumber, int numberOfRows, int numberOfColumns) {
        Table gameTable = new Table(baseNumber, numberOfRows, numberOfColumns);
        GameContents.setCurrentGame(gameTable);
        Notify.logMessage("Game created.");
    }

    @Override
    public void move(Directon directon) {
        Table currentGame = GameContents.getCurrentGame();
        currentGame.move(directon);
        loadGameTable();//todo2 remove it
    }
}
