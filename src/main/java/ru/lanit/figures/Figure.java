package ru.lanit.figures;


public abstract class Figure {
    private int col;
    private int row;
    private boolean isWhite;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public abstract String[][] fillBoard(String[][] board);

    public abstract boolean canMove(String[][] board);

    public abstract String[][] move(String[][] board);

}
