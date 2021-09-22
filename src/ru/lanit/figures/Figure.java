package ru.lanit.figures;


public abstract class Figure {
    private int x;
    private int y;
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

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public abstract String[][] fillBoard(String[][] board);

    public abstract boolean canMove(String[][] board);

    public abstract String[][] move(String[][] board);

}
