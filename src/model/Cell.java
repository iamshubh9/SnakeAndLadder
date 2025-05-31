package model;

public class Cell {
    private SnakeLadder snakeLadder;

    public Cell() {
        snakeLadder = null;
    }
    public Cell(SnakeLadder snakeLadder) {
        this.snakeLadder = snakeLadder;
    }

    public SnakeLadder getSnakeLadder() {
        return snakeLadder;
    }

    public void setSnakeLadder(SnakeLadder snakeLadder) {
        this.snakeLadder = snakeLadder;
    }
}
