package models;

import java.util.Random;

public class Table {
    private int newNumberOfEachTurn;
    private int numberOfRows;
    private int numberOfColumns;
    private Cell[][] cells = new Cell[numberOfRows][numberOfColumns];

    private int score = 0;

    public Table(int newNumberOfEachTurn, int numberOfRows, int numberOfColumns) {
        this.newNumberOfEachTurn = newNumberOfEachTurn;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        initCells();
    }

    private void initCells(){
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private int makeNewNumber() {
        int zeroOrOne = Math.abs(new Random().nextInt()) % 2;
        return (zeroOrOne + 1) * newNumberOfEachTurn;
    }

    private void clockWiseQuarterRotation(int rotationCount) {

    }
}
