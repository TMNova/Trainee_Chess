package ru.lanit.figures;

import ru.lanit.board.ChessBoard;

import org.apache.commons.lang3.RandomUtils;



public class Bishop extends Figure {
    private RandomUtils random = new RandomUtils();

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
            if (ChessBoard.emptyCell.equals(board[7][2])) {
                board[7][2] = getType();
                setCol(7);
                setRow(2);
                return board;
            } else if (ChessBoard.emptyCell.equals(board[7][5])) {
                board[7][5] = getType();
                setCol(7);
                setRow(5);
                return board;
            }
        } else {
            if (ChessBoard.emptyCell.equals(board[0][2])) {
                board[0][2] = getType();
                setCol(0);
                setRow(2);
                return board;
            } else if (ChessBoard.emptyCell.equals(board[0][5])) {
                board[0][5] = getType();
                setCol(0);
                setRow(5);
                return board;
            }
        }
        return board;

    }

    @Override
    public boolean canMove(String[][] board) {
        if (!board[getCol()][getRow()].equals(getType())) return false;
        if (isWhite()) {
            if (getCol() < 7 && getRow() < 7) {
                return ChessBoard.emptyCell.equals(board[getCol() + 1][getRow() + 1])
                        || (board[getCol() + 1][getRow() + 1].charAt(1)) != ChessBoard.whiteFigureCell;
            } else if (getCol() > 0 && getRow() > 0) {
                return ChessBoard.emptyCell.equals(board[getCol() - 1][getRow() - 1])
                        || (board[getCol() - 1][getRow() - 1].charAt(1)) != ChessBoard.whiteFigureCell;
            } else if (getCol() > 0 && getRow() < 7) {
                return ChessBoard.emptyCell.equals(board[getCol() - 1][getRow() + 1])
                        || (board[getCol() - 1][getRow() + 1].charAt(1)) != ChessBoard.whiteFigureCell;
            } else if (getCol() < 7 && getRow() > 0) {
                return ChessBoard.emptyCell.equals(board[getCol() + 1][getRow() - 1])
                        || (board[getCol() + 1][getRow() - 1].charAt(1)) != ChessBoard.whiteFigureCell;
            }
        } else {
                if (getCol() < 7 && getRow() < 7) {
                    return ChessBoard.emptyCell.equals(board[getCol() + 1][getRow() + 1])
                            || (board[getCol() + 1][getRow() + 1].charAt(1)) != ChessBoard.blackFigureCell;
                } else if (getCol() > 0 && getRow() > 0) {
                    return ChessBoard.emptyCell.equals(board[getCol() - 1][getRow() - 1])
                            || (board[getCol() - 1][getRow() - 1].charAt(1)) != ChessBoard.blackFigureCell;
                } else if (getCol() > 0 && getRow() < 7) {
                    return ChessBoard.emptyCell.equals(board[getCol() - 1][getRow() + 1])
                            || (board[getCol() - 1][getRow() + 1].charAt(1)) != ChessBoard.blackFigureCell;
                } else if (getCol() < 7 && getRow() > 0) {
                    return ChessBoard.emptyCell.equals(board[getCol() + 1][getRow() - 1])
                            || (board[getCol() + 1][getRow() - 1].charAt(1)) != ChessBoard.blackFigureCell;
                }
        }
        return false;
    }

    @Override
    public String[][] move(String[][] board) {
        if (!(canMove(board))) return board;
        if (isWhite()) {
            int cloneCol = getCol();
            int cloneRow = getRow();
            while (cloneCol == getCol() && cloneRow == getRow()) {
                int rand = random.nextInt(0, 8);
                        if (getCol() - rand > 0 && getRow() - rand > 0
                                && ((board[getCol() - rand][getRow() - rand].equals(ChessBoard.emptyCell))
                                || (board[getCol() - rand][getRow() - rand].charAt(1) != ChessBoard.whiteFigureCell))) {
                            board[getCol() - rand][getRow() - rand] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - rand);
                            setRow(getRow() - rand);
                            System.out.println(0);
                            return board;
                        } else if (getCol() + rand < 7 && getRow() + rand < 7
                                && ((board[getCol() + rand][getRow() + rand].equals(ChessBoard.emptyCell))
                                || (board[getCol() + rand][getRow() + rand].charAt(1) != ChessBoard.whiteFigureCell))) {
                            board[getCol() + rand][getRow() + rand] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + rand);
                            setRow(getRow() + rand);
                            System.out.println(1);
                            return board;
                        } else if (getCol() + rand < 7 && getRow() - rand > 0
                                && ((board[getCol() + rand][getRow() - rand].equals(ChessBoard.emptyCell))
                                || (board[getCol() + rand][getRow() - rand].charAt(1) != ChessBoard.whiteFigureCell))) {
                            board[getCol() + rand][getRow() - rand] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + rand);
                            setRow(getRow() - rand);
                            System.out.println(2);
                            return board;
                        }else if (getCol() - rand > 0 && getRow() + rand < 7
                                && ((board[getCol() - rand][getRow() + rand].equals(ChessBoard.emptyCell))
                                || (board[getCol() - rand][getRow() + rand].charAt(1) != ChessBoard.whiteFigureCell))) {
                            board[getCol() - rand][getRow() + rand] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - rand);
                            setRow(getRow() + rand);
                            System.out.println(3);
                            return board;
                        }
            }

        } else {
            int cloneCol = getCol();
            int cloneRow = getRow();
            while (cloneCol == getCol() && cloneRow == getRow()) {
                int rand = random.nextInt(0, 8);
                        if (getCol() - rand > 0 && getRow() - rand > 0
                                && ((board[getCol() - rand][getRow() - rand].equals(ChessBoard.emptyCell))
                                || (board[getCol() - rand][getRow() - rand].charAt(1) != ChessBoard.whiteFigureCell))) {
                            board[getCol() - rand][getRow() - rand] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - rand);
                            setRow(getRow() - rand);
                            return board;
                        } else if (getCol() + rand < 7 && getRow() + rand < 7
                                && ((board[getCol() + rand][getRow() + rand].equals(ChessBoard.emptyCell))
                                || (board[getCol() + rand][getRow() + rand].charAt(1) != ChessBoard.whiteFigureCell))) {
                            board[getCol() + rand][getRow() + rand] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + rand);
                            setRow(getRow() + rand);
                            return board;
                        } else if (getCol() + rand < 7 && getRow() - rand > 0
                                && ((board[getCol() + rand][getRow() - rand].equals(ChessBoard.emptyCell))
                                || (board[getCol() + rand][getRow() - rand].charAt(1) != ChessBoard.whiteFigureCell))) {
                            board[getCol() + rand][getRow() - rand] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + rand);
                            setRow(getRow() - rand);
                            return board;
                        } else if (getCol() - rand > 0 && getRow() + rand < 7
                                && ((board[getCol() - rand][getRow() + rand].equals(ChessBoard.emptyCell))
                                || (board[getCol() - rand][getRow() + rand].charAt(1) != ChessBoard.whiteFigureCell))) {
                            board[getCol() - rand][getRow() + rand] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - rand);
                            setRow(getRow() + rand);
                            return board;
                        }
                }
            }
        return board;
    }

}