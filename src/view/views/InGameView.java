package view.views;

import contracts.InGameContract;
import models.Cell;
import models.Table;

public class InGameView implements InGameContract.View {
    @Override
    public void showGameTable(Table table) {
        int numberOfRows = table.getNumberOfRows();
        int numberOfColumns = table.getNumberOfColumns();
        Cell[][] cells = table.getCells();
        int score = table.getScore();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                System.out.printf("%5d", cells[i][j].getValue());
            }
            System.out.print("\n");
        }
        System.out.println("Score:  " + score);
    }
}
