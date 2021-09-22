package ru.lanit.figures;

import java.util.Random;

public class Pawn extends Figure {
    Random r = new Random();

    public Pawn(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("PW");
        } else {
            setType("PB");
        }
    }

    @Override
    public String[][] fillBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            if ("-".equals(board[6][i]) && isWhite()) {
                board[6][i] = getType();
                setX(6);
                setY(i);
                return board;
            } else if ("-".equals(board[1][i]) && !(isWhite())) {
                board[1][i] = getType();
                setX(1);
                setY(i);
                return board;
            }
        }
        return board;
    }

    @Override
    public boolean canMove(String[][] board) {
        String a = isWhite() ? "true" : "false";
        switch (a) {
            case "true":
                if (getX() == 0) {
                    return false;
                }
                if (!board[getX() - 1][getY()].equals("-") && board[getX() - 1][getY()].charAt(1) == 'W') return false;
                if (getX() > 0 && getType().equals(board[getX()][getY()])) {
                    return ("-".equals(board[getX() - 1][getY()]))
                            || (getY() > 0 && !board[getX() - 1][getY() - 1].equals("-") && !board[getX() - 1][getY() - 1].equals("PW"))
                            || (getY() < 7 && !board[getX() - 1][getY() + 1].equals("-") && !board[getX() - 1][getY() + 1].equals("PW"));
                }
            case "false":
                if (getX() == 7) {
                    return false;
                }
                if (!board[getX() + 1][getY()].equals("-") && board[getX() + 1][getY()].charAt(1) == 'B') return false;

                if (getX() < 7 && board[getX()][getY()].equals(getType())) {
                    return ("-".equals(board[getX() + 1][getY()]))
                            || (getY() > 0 && !board[getX() + 1][getY() - 1].equals("-") && !board[getX() + 1][getY() - 1].equals("PB"))
                            || (getY() < 7 && !board[getX() + 1][getY() + 1].equals("-") && !board[getX() + 1][getY() + 1].equals("PB"));
                }
        }
        return false;
    }

    @Override
    public String[][] move(String[][] board) {
        if (!(canMove(board))) return board;
        if (isWhite()) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = r.nextInt(3);
                switch (rand) {
                    case 0:
                        if (getX() > 0 && (!board[getX() - 1][getY()].equals("-") && board[getX() - 1][getY()].charAt(1) != 'W') || board[getX() - 1][getY()].equals("-")) {
                            board[getX() - 1][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - 1);
                            setY(getY());
                            return board;
                        }
                    case 1:
                        if (getY() > 0 && getX() > 0 && !board[getX() - 1][getY() - 1].equals("-") && board[getX() - 1][getY() - 1].charAt(1) == 'B') {
                            board[getX() - 1][getY() - 1] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - 1);
                            setY(getY() - 1);
                            return board;
                        }
                    case 2:
                        if (getY() < 7 && getX() > 0 && !board[getX() - 1][getY() + 1].equals("-") && board[getX() - 1][getY() + 1].charAt(1) == 'B') {
                            board[getX() - 1][getY() + 1] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - 1);
                            setY(getY() + 1);
                            return board;
                        }
                }
            }
        } else if (!(isWhite())) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = r.nextInt(3);
                switch (rand) {
                    case 0:
                        if (getX() < 7 && (!board[getX() + 1][getY()].equals("-") && board[getX() + 1][getY()].charAt(1) != 'B') || board[getX() + 1][getY()].equals("-")) {
                            board[getX() + 1][getY()] = "PB";
                            board[getX()][getY()] = "-";
                            setX(getX() + 1);
                            setY(getY());
                            return board;
                        }
                    case 1:
                        if (getY() > 0 && getX() < 7 && !("-".equals(board[getX() + 1][getY() - 1])) && board[getX() + 1][getY() - 1].charAt(1) == 'W') {
                            board[getX() + 1][getY() - 1] = "PB";
                            board[getX()][getY()] = "-";
                            setX(getX() + 1);
                            setY(getY() - 1);
                            return board;
                        }
                    case 2:
                        if (getY() < 7 && getX() < 7 && !board[getX() + 1][getY() + 1].equals("-") && board[getX() + 1][getY() + 1].charAt(1) == 'W') {
                            board[getX() + 1][getY() + 1] = "PB";
                            board[getX()][getY()] = "-";
                            setX(getX() + 1);
                            setY(getY() + 1);
                            return board;
                        }
                }
            }
        }
        return board;

    }
}
