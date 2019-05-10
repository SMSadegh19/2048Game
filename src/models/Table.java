package models;

import java.util.Random;

public class Table {
    private int baseNumber;
    private int numberOfRows;
    private int numberOfColumns;
    private Cell[][] cells = new Cell[numberOfRows][numberOfColumns];

    private int score = 0;

    public Table(int baseNumber, int numberOfRows, int numberOfColumns) {
        this.baseNumber = baseNumber;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        initCells(cells);
    }

    private void initCells(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[j].length; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private int makeNewNumber() {
        int zeroOrOne = Math.abs(new Random().nextInt()) % 2;
        return (zeroOrOne + 1) * baseNumber;
    }

    private void clockWiseQuarterRotation(int rotationCount) {
        for (int rotationNumber = 0; rotationNumber < rotationCount; rotationNumber++) {
            Cell[][] newCells = new Cell[numberOfColumns][numberOfRows];
            initCells(newCells);
            for (int i = 0; i < numberOfColumns; i++) {
                for (int j = 0; j < numberOfRows; j++) {
                    newCells[i][j].setValue(cells[numberOfRows - 1 - j][i].getValue());
                }
            }

            cells = newCells;
            int temp = numberOfRows;
            numberOfRows = numberOfColumns;
            numberOfColumns = temp;
        }
    }

    public void move(Directon directon) {
        int rotationCount = 0;
        switch (directon) {
            case LEFT:
                rotationCount = 3;
            case UP:
                rotationCount = 2;
            case RIGHT:
                rotationCount = 1;
            case DOWN:
                rotationCount = 0;
        }
        clockWiseQuarterRotation(rotationCount);
        hitDown();
        clockWiseQuarterRotation(4 - rotationCount);
    }

    private void hitDown() {

    }

    private boolean canDropDown() {
        for (int j = 0; j < numberOfColumns; j++) {
            for (int i = 0; i < numberOfRows; i++) {
                if (canDropDownColumn(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canDropDownColumn(int columnNumber) {
        if (!columnIsFull(columnNumber)) {
            return true;
        }
        for (int i = 0; i < numberOfRows - 1; i++) {
            if (cells[i][columnNumber].getValue() == cells[i + 1][columnNumber].getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean columnIsFull(int columnNumber) {
        for (int i = 0; i < numberOfRows; i++) {
            if (cells[i][columnNumber].getValue() == 0) {
                return false;
            }
        }
        return true;
    }
}
