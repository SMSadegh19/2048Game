package models;

import java.util.ArrayList;
import java.util.Random;

public class Tools {
    private static Random random = new Random();

    public static Cell[][] getCellsCopy(Cell[][] src) {
        Cell[][] copy = new Cell[src.length][];
        for (int i = 0; i < src.length; i++) {
            copy[i] = new Cell[src[i].length];
            for (int j = 0; j < src[i].length; j++) {
                copy[i][j] = new Cell(src[i][j]);
            }
        }
        return copy;
    }

    public static void initCells(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public static boolean cellsEqual(Cell[][] cells1, Cell[][] cells2) {
        for (int i = 0; i < cells1.length; i++) {
            for (int j = 0; j < cells1[i].length; j++) {
                Cell cell1 = cells1[i][j];
                Cell cell2 = cells2[i][j];
                if (cell1.getValue() != cell2.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int makeNewNumber(int baseNumber) {
        int zeroOrOne = random.nextInt(2);
        return (zeroOrOne + 1) * baseNumber;
    }

    public static Cell getRandomEmptyCell(Cell[][] cells) {
        ArrayList<Cell> emptyCells = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getValue() == 0) {
                    emptyCells.add(cells[i][j]);
                }
            }
        }
        if (emptyCells.size() == 0) {
            return null;
        }
        return emptyCells.get(random.nextInt(emptyCells.size()));
    }

    public static int randomNumber(int bound) {
        return random.nextInt(bound);
    }
}
