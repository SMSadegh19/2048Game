package models;

public class Cell {
    private int value;

    public Cell() {
        value = 0;
    }

    public Cell(int value) {
        this.value = value;
    }

    public Cell(Cell cell) {
        this.value = cell.value;
    }

    public Cell(Cell cell1, Cell cell2) {
        this.value = cell1.value + cell2.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
