package ru.lanit.figures;

import java.util.Random;

public class Bishop extends Figure {
    Random r = new Random();

    public Bishop(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("BW");
        } else {
            setType("BB");
        }
    }

    @Override
    public String[][] fillBoard(String[][] board) {
        if (isWhite()) {
            if ("-".equals(board[7][2])) {
                board[7][2] = getType();
                setX(7);
                setY(2);
                return board;
            } else if ("-".equals(board[7][5])) {
                board[7][5] = getType();
                setX(7);
                setY(5);
                return board;
            }
        } else if (!(isWhite())) {
            if ("-".equals(board[0][2])) {
                board[0][2] = getType();
                setX(0);
                setY(2);
                return board;
            } else if ("-".equals(board[0][5])) {
                board[0][5] = getType();
                setX(0);
                setY(5);
                return board;
            }
        }
        return board;

    }

    @Override
    public boolean canMove(String[][] board) {
        if (!board[getX()][getY()].equals(getType())) return false;
        String a = isWhite() ? "true" : "false";
        switch (a) {
            case "true":
                if (getX() < 7 && getY() < 7) {
                    return "-".equals(board[getX() + 1][getY() + 1])
                            || (board[getX() + 1][getY() + 1].charAt(1)) != 'W';
                } else if (getX() > 0 && getY() > 0) {
                    return "-".equals(board[getX() - 1][getY() - 1])
                            || (board[getX() - 1][getY() - 1].charAt(1)) != 'W';
                } else if (getX() > 0 && getY() < 7) {
                    return "-".equals(board[getX() - 1][getY() + 1])
                            || (board[getX() - 1][getY() + 1].charAt(1)) != 'W';
                } else if (getX() < 7 && getY() > 0) {
                    return "-".equals(board[getX() + 1][getY() - 1])
                            || (board[getX() + 1][getY() - 1].charAt(1)) != 'W';
                }
                break;
            case "false":
                if (getX() < 7 && getY() < 7) {
                    return "-".equals(board[getX() + 1][getY() + 1])
                            || (board[getX() + 1][getY() + 1].charAt(1)) != 'B';
                } else if (getX() > 0 && getY() > 0) {
                    return "-".equals(board[getX() - 1][getY() - 1])
                            || (board[getX() - 1][getY() - 1].charAt(1)) != 'B';
                } else if (getX() > 0 && getY() < 7) {
                    return "-".equals(board[getX() - 1][getY() + 1])
                            || (board[getX() - 1][getY() + 1].charAt(1)) != 'B';
                } else if (getX() < 7 && getY() > 0) {
                    return "-".equals(board[getX() + 1][getY() - 1])
                            || (board[getX() + 1][getY() - 1].charAt(1)) != 'B';
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
                int rand = 0;
                int rand2 = r.nextInt(8);
                switch (rand) {
                    case 0:
                        if (getX() - rand2 > 0 && getY() - rand2 > 0
                                && ((board[getX() - rand2][getY() - rand2].equals("-"))
                                || (board[getX() - rand2][getY() - rand2].charAt(1) != 'W'))) {
                            board[getX() - rand2][getY() - rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - rand2);
                            setY(getY() - rand2);
                            System.out.println(0);
                            return board;
                        }
                    case 1:
                        if (getX() + rand2 < 7 && getY() + rand2 < 7
                                && ((board[getX() + rand2][getY() + rand2].equals("-"))
                                || (board[getX() + rand2][getY() + rand2].charAt(1) != 'W'))) {
                            board[getX() + rand2][getY() + rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() + rand2);
                            setY(getY() + rand2);
                            System.out.println(1);
                            return board;
                        }
                    case 2:
                        if (getX() + rand2 < 7 && getY() - rand2 > 0
                                && ((board[getX() + rand2][getY() - rand2].equals("-"))
                                || (board[getX() + rand2][getY() - rand2].charAt(1) != 'W'))) {
                            board[getX() + rand2][getY() - rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() + rand2);
                            setY(getY() - rand2);
                            System.out.println(2);
                            return board;
                        }
                    case 3:
                        if (getX() - rand2 > 0 && getY() + rand2 < 7
                                && ((board[getX() - rand2][getY() + rand2].equals("-"))
                                || (board[getX() - rand2][getY() + rand2].charAt(1) != 'W'))) {
                            board[getX() - rand2][getY() + rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - rand2);
                            setY(getY() + rand2);
                            System.out.println(3);
                            return board;
                        }
                }
            }

        } else if (!(isWhite())) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = 0;
                int rand2 = r.nextInt(8);
                switch (rand) {
                    case 0:
                        if (getX() - rand2 > 0 && getY() - rand2 > 0
                                && ((board[getX() - rand2][getY() - rand2].equals("-"))
                                || (board[getX() - rand2][getY() - rand2].charAt(1) != 'W'))) {
                            board[getX() - rand2][getY() - rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - rand2);
                            setY(getY() - rand2);
                            return board;
                        }
                    case 1:
                        if (getX() + rand2 < 7 && getY() + rand2 < 7
                                && ((board[getX() + rand2][getY() + rand2].equals("-"))
                                || (board[getX() + rand2][getY() + rand2].charAt(1) != 'W'))) {
                            board[getX() + rand2][getY() + rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() + rand2);
                            setY(getY() + rand2);
                            return board;
                        }
                    case 2:
                        if (getX() + rand2 < 7 && getY() - rand2 > 0
                                && ((board[getX() + rand2][getY() - rand2].equals("-"))
                                || (board[getX() + rand2][getY() - rand2].charAt(1) != 'W'))) {
                            board[getX() + rand2][getY() - rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() + rand2);
                            setY(getY() - rand2);
                            return board;
                        }
                    case 3:
                        if (getX() - rand2 > 0 && getY() + rand2 < 7
                                && ((board[getX() - rand2][getY() + rand2].equals("-"))
                                || (board[getX() - rand2][getY() + rand2].charAt(1) != 'W'))) {
                            board[getX() - rand2][getY() + rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - rand2);
                            setY(getY() + rand2);
                            return board;
                        }
                }
            }
        }
        return board;
    }

}