package ru.lanit.figures;

import java.util.Random;

public class Queen extends Figure {
    Random r = new Random();
    final byte[][] STEPS = new byte[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
    };


    public Queen(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("QW");
        } else {
            setType("QB");
        }
    }

    @Override
    public String[][] fillBoard(String[][] board) {
        if (isWhite()) {
            board[7][3] = getType();
            setX(7);
            setY(3);
            return board;
        } else if (!(isWhite())) {
            board[0][3] = getType();
            setX(0);
            setY(3);
            return board;
        }
        return board;
    }

    @Override
    public boolean canMove(String[][] board) {
        if (isWhite()) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getX() + STEPS[i][0] < 7 && getX() + STEPS[i][0] > 0 && getY() + STEPS[i][1] < 7 && getY() + STEPS[i][1] > 0
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'B')) {
                    return true;
                }
            }
            return false;
        } else if (!(isWhite())) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getX() + STEPS[i][0] < 7 && getX() + STEPS[i][0] > 0 && getY() + STEPS[i][1] < 7 && getY() + STEPS[i][1] > 0
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'W')) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String[][] move(String[][] board) {
        if (isWhite() && canMove(board)) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int i = r.nextInt(8);
                if ((getX() + STEPS[i][0] > 0 && getX() + STEPS[i][0] < 7
                        && getY() + STEPS[i][1] > 0 && getY() + STEPS[i][1] < 7)
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'B')) {
                    board[getX() + STEPS[i][0]][getY() + STEPS[i][1]] = getType();
                    board[getX()][getY()] = "-";
                    setX(getX() + STEPS[i][0]);
                    setY(getY() + STEPS[i][1]);
                    return board;
                }
            }
        } else if (!(isWhite()) && canMove(board)) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int i = r.nextInt(8);
                if ((getX() + STEPS[i][0] > 0 && getX() + STEPS[i][0] < 7
                        && getY() + STEPS[i][1] > 0 && getY() + STEPS[i][1] < 7)
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'W')) {
                    board[getX() + STEPS[i][0]][getY() + STEPS[i][1]] = getType();
                    board[getX()][getY()] = "-";
                    setX(getX() + STEPS[i][0]);
                    setY(getY() + STEPS[i][1]);
                    return board;
                }
            }

        }
        return board;

    }

}