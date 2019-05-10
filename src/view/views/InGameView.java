package view.views;

import contracts.InGameContract;
import models.Table;

public class InGameView implements InGameContract.View {
    private InGameContract.Controller controller;

    @Override
    public void setController(InGameContract.Controller controller) {
        this.controller = controller;
    }

    @Override
    public void showGameTable(Table table) {
        // TODO: 5/10/19
    }
}
