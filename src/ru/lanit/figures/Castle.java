package ru.lanit.figures;

import java.util.Random;

public class Castle extends Figure {
    Random r = new Random();

    public Castle(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("CW");
        } else {
            setType("CB");
        }
    }

    @Override
    public String[][] fillBoard(String[][] board) {
        if (isWhite()) {
            if ("-".equals(board[7][0])) {
                board[7][0] = getType();
                setX(7);
                setY(0);
                return board;
            } else if ("-".equals(board[7][7])) {
                board[7][7] = getType();
                setX(7);
                setY(7);
                return board;
            }
        } else if (!(isWhite())) {
            if ("-".equals(board[0][0])) {
                board[0][0] = getType();
                setX(0);
                setY(0);
                return board;
            } else if ("-".equals(board[0][7])) {
                board[0][7] = getType();
                setX(0);
                setY(7);
                return board;
            }
        }
        return board;
    }

    @Override
    public boolean canMove(String[][] board) {
        if (!board[getX()][getY()].equals(getType())) return false;
        if (isWhite()) {
            return (getX() < 7 && ("-".equals(board[getX() + 1][getY()]) || board[getX() + 1][getY()].charAt(1) == 'B'))
                    || (getX() > 0 && ("-".equals(board[getX() - 1][getY()]) || board[getX() - 1][getY()].charAt(1) == 'B'))
                    || (getY() < 7 && ("-".equals(board[getX()][getY() + 1]) || board[getX()][getY() + 1].charAt(1) == 'B'))
                    || (getY() > 0 && ("-".equals(board[getX()][getY() - 1]) || board[getX()][getY() - 1].charAt(1) == 'B'));
        } else if (!(isWhite())) {
            return (getX() < 7 && ("-".equals(board[getX() + 1][getY()]) || board[getX() + 1][getY()].charAt(1) == 'W'))
                    || (getX() > 0 && ("-".equals(board[getX() - 1][getY()]) || board[getX() - 1][getY()].charAt(1) == 'W'))
                    || (getY() < 7 && ("-".equals(board[getX()][getY() + 1]) || board[getX()][getY() + 1].charAt(1) == 'W'))
                    || (getY() > 0 && ("-".equals(board[getX()][getY() - 1]) || board[getX()][getY() - 1].charAt(1) == 'W'));
        }

        return false;
    }

    @Override
    public String[][] move(String[][] board) {
        if (isWhite()) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = r.nextInt(4);
                int rand2 = r.nextInt(8);
                switch (rand) {
                    case 0:
                        if ((getX() + rand2 < 7 && ("-".equals(board[getX() + rand2][getY()]) || board[getX() + rand2][getY()].charAt(1) == 'B'))) {
                            board[getX() + rand2][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() + rand2);
                            setY(getY());
                            return board;
                        }
                    case 1:
                        if ((getX() - rand2 > 0 && ("-".equals(board[getX() - rand2][getY()]) || board[getX() - rand2][getY()].charAt(1) == 'B'))) {
                            board[getX() - rand2][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - rand2);
                            setY(getY());
                            return board;
                        }
                    case 2:
                        if ((getY() - rand2 > 0 && ("-".equals(board[getX()][getY() - rand2]) || board[getX()][getY() - rand2].charAt(1) == 'B'))) {
                            board[getX()][getY() - rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX());
                            setY(getY() - rand2);
                            return board;
                        }
                    case 3:
                        if ((getY() + rand2 < 7 && ("-".equals(board[getX()][getY() + rand2]) || board[getX()][getY() + rand2].charAt(1) == 'B'))) {
                            board[getX()][getY() + rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX());
                            setY(getY() + rand2);
                            return board;
                        }
                }
            }
        } else if (!(isWhite())) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = r.nextInt(4);
                int rand2 = r.nextInt(8);
                switch (rand) {
                    case 0:
                        if ((getX() + rand2 < 7 && ("-".equals(board[getX() + rand2][getY()]) || board[getX() + rand2][getY()].charAt(1) == 'W'))) {
                            board[getX() + rand2][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() + rand2);
                            setY(getY());
                            return board;
                        }
                    case 1:
                        if ((getX() - rand2 > 0 && ("-".equals(board[getX() - rand2][getY()]) || board[getX() - rand2][getY()].charAt(1) == 'W'))) {
                            board[getX() - rand2][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - rand2);
                            setY(getY());
                            return board;
                        }
                    case 2:
                        if ((getY() - rand2 > 0 && ("-".equals(board[getX()][getY() - rand2]) || board[getX()][getY() - rand2].charAt(1) == 'W'))) {
                            board[getX()][getY() - rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX());
                            setY(getY() - rand2);
                            return board;
                        }
                    case 3:
                        if ((getY() + rand2 < 7 && ("-".equals(board[getX()][getY() + rand2]) || board[getX()][getY() + rand2].charAt(1) == 'W'))) {
                            board[getX()][getY() + rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX());
                            setY(getY() + rand2);
                            return board;
                        }
                }
            }
        }
        return board;
    }
}
