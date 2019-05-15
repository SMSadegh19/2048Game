package models;

import view.Notify;

import java.util.ArrayList;

public class Table {
    private int baseNumber;
    private int numberOfRows;
    private int numberOfColumns;
    private Cell[][] cells;

    private int score = 0;

    public int getBaseNumber() {
        return baseNumber;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getScore() {
        return score;
    }

    public Table(int baseNumber, int numberOfRows, int numberOfColumns) {
        this.baseNumber = baseNumber;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        cells = new Cell[numberOfRows][numberOfColumns];
        Tools.initCells(cells);
        releaseNewNumber();
    }

    private void clockWiseQuarterRotation(int rotationCount) {
        for (int rotationNumber = 0; rotationNumber < rotationCount; rotationNumber++) {
            Cell[][] newCells = new Cell[numberOfColumns][numberOfRows];
            Tools.initCells(newCells);
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
        int rotationCount = 4;
        switch (directon) {
            case LEFT:
                rotationCount = 3;
                break;
            case UP:
                rotationCount = 2;
                break;
            case RIGHT:
                rotationCount = 1;
                break;
            case DOWN:
                rotationCount = 0;
                break;
        }

        Cell[][] oldCells = Tools.getCellsCopy(cells);

        clockWiseQuarterRotation(rotationCount);
        dropDown();
        clockWiseQuarterRotation((4 - rotationCount) % 4);


        if (!Tools.cellsEqual(oldCells, cells)) {
            releaseNewNumber();
        }
        if (!canMove()) {
            Notify.logMessage("GAME OVER!!");
        }
    }

    private boolean canMove() {
        boolean canMove = false;
        for (int i = 0; i < 4; i++) {
            clockWiseQuarterRotation(i);
            if (canDropDown()) {
                canMove = true;
            }
            clockWiseQuarterRotation((4 - i) % 4);
            if (canMove) {
                return true;
            }
        }
        return false;
    }

    private void releaseNewNumber() {
        Cell randomEmptyCell = Tools.getRandomEmptyCell(cells);
        if (randomEmptyCell != null) {
            randomEmptyCell.setValue(Tools.makeNewNumber(baseNumber));
        }
    }

    private void dropDown() {
        if (!canDropDown()) {
            return;
        }
        for (int j = 0; j < numberOfColumns; j++) {
            if (canDropDownColumn(j)) {
                dropDownColumn(j);
            }
        }
    }

    private void dropDownColumn(int columnNumber) {
        ArrayList<Cell> newColumn = new ArrayList<>();

        outer:
        for (int i = numberOfRows - 1; i >= 0; i--) {
            Cell cell1 = cells[i][columnNumber];
            if (cell1.getValue() == 0) {
                continue;
            }

            if (i == 0) {
                newColumn.add(0, new Cell(cell1));
                continue;
            }

            for (int j = i - 1; j >= 0; j--) {
                Cell cell2 = cells[j][columnNumber];
                if (cell2.getValue() == 0) {
                    if (j == 0) {
                        newColumn.add(0, new Cell(cell1));
                        break outer;
                    } else {
                        continue;
                    }
                }

                if (cell1.getValue() == cell2.getValue()) {
                    Cell mergedCell = new Cell(cell1, cell2);
                    score += mergedCell.getValue();
                    newColumn.add(0, mergedCell);
                    i = j;
                    continue outer;
                } else {
                    newColumn.add(0, new Cell(cell1));
                    continue outer;
                }
            }
        }

        replaceColumn(columnNumber, newColumn);
    }

    private void replaceColumn(int columnNumber, ArrayList<Cell> newColumn) {
        for (int i = 0; i < numberOfRows; i++) {
            cells[i][columnNumber] = new Cell();
        }
        for (int i = 0; i < newColumn.size(); i++) {
            cells[i + numberOfRows - newColumn.size()][columnNumber] = new Cell(newColumn.get(i));
        }
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
