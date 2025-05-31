package model;

public class Board {
    Cell[][] cells;
    int size;
    int numberOfSnakes;
    int numberOfLadders;

    public Board(int size, int numberOfSnakes, int numberOfLadders) {
        this.size = size;
        this.numberOfSnakes = numberOfSnakes;
        this.numberOfLadders = numberOfLadders;
        cells = new Cell[size][size];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberOfSnakes() {
        return numberOfSnakes;
    }

    public void setNumberOfSnakes(int numberOfSnakes) {
        this.numberOfSnakes = numberOfSnakes;
    }

    public int getNumberOfLadders() {
        return numberOfLadders;
    }

    public void setNumberOfLadders(int numberOfLadders) {
        this.numberOfLadders = numberOfLadders;
    }
}
