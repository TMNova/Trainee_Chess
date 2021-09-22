package ru.lanit.figures;

import ru.lanit.board.ChessBoard;

import java.util.Random;

public class Pawn extends Figure {
    private Random random = new Random();

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
            if (ChessBoard.emptyCell.equals(board[6][i]) && isWhite()) {
                board[6][i] = getType();
                setCol(6);
                setRow(i);
                return board;
            } else if (ChessBoard.emptyCell.equals(board[1][i]) && !(isWhite())) {
                board[1][i] = getType();
                setCol(1);
                setRow(i);
                return board;
            }
        }
        return board;
    }

    @Override
    public boolean canMove(String[][] board) {
        if (isWhite()) {
            if (getCol() == 0) {
                return false;
            }
            if (!board[getCol() - 1][getRow()].equals(ChessBoard.emptyCell) && board[getCol() - 1][getRow()].charAt(1) == ChessBoard.whiteFigureCell)
                return false;
            if (getCol() > 0 && getType().equals(board[getCol()][getRow()])) {
                return (ChessBoard.emptyCell.equals(board[getCol() - 1][getRow()]))
                        || (getRow() > 0 && !board[getCol() - 1][getRow() - 1].equals(ChessBoard.emptyCell) && !board[getCol() - 1][getRow() - 1].equals(getType()))
                        || (getRow() < 7 && !board[getCol() - 1][getRow() + 1].equals(ChessBoard.emptyCell) && !board[getCol() - 1][getRow() + 1].equals(getType()));
            }
        } else {

            if (getCol() == 7) return false;
            if (!board[getCol() + 1][getRow()].equals(ChessBoard.emptyCell) && board[getCol() + 1][getRow()].charAt(1) == ChessBoard.blackFigureCell)
                return false;

            if (getCol() < 7 && board[getCol()][getRow()].equals(getType())) {
                return (ChessBoard.emptyCell.equals(board[getCol() + 1][getRow()]))
                        || (getRow() > 0 && !board[getCol() + 1][getRow() - 1].equals(ChessBoard.emptyCell) && !board[getCol() + 1][getRow() - 1].equals(getType()))
                        || (getRow() < 7 && !board[getCol() + 1][getRow() + 1].equals(ChessBoard.emptyCell) && !board[getCol() + 1][getRow() + 1].equals(getType()));
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
                int rand = random.nextInt(3);
                switch (rand) {
                    case 0:
                        if (getCol() > 0 && (!board[getCol() - 1][getRow()].equals(ChessBoard.emptyCell) && board[getCol() - 1][getRow()].charAt(1) != ChessBoard.whiteFigureCell) || board[getCol() - 1][getRow()].equals(ChessBoard.emptyCell)) {
                            board[getCol() - 1][getRow()] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - 1);
                            setRow(getRow());
                            return board;
                        }
                    case 1:
                        if (getRow() > 0 && getCol() > 0 && !board[getCol() - 1][getRow() - 1].equals(ChessBoard.emptyCell) && board[getCol() - 1][getRow() - 1].charAt(1) == ChessBoard.blackFigureCell) {
                            board[getCol() - 1][getRow() - 1] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - 1);
                            setRow(getRow() - 1);
                            return board;
                        }
                    case 2:
                        if (getRow() < 7 && getCol() > 0 && !board[getCol() - 1][getRow() + 1].equals(ChessBoard.emptyCell) && board[getCol() - 1][getRow() + 1].charAt(1) == ChessBoard.blackFigureCell) {
                            board[getCol() - 1][getRow() + 1] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - 1);
                            setRow(getRow() + 1);
                            return board;
                        }
                }
            }
        } else {
            int cloneCol = getCol();
            int cloneRow = getRow();
            while (cloneCol == getCol() && cloneRow == getRow()) {
                int rand = random.nextInt(3);
                switch (rand) {
                    case 0:
                        if (getCol() < 7 && (!board[getCol() + 1][getRow()].equals(ChessBoard.emptyCell) && board[getCol() + 1][getRow()].charAt(1) != ChessBoard.blackFigureCell) || board[getCol() + 1][getRow()].equals(ChessBoard.emptyCell)) {
                            board[getCol() + 1][getRow()] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + 1);
                            setRow(getRow());
                            return board;
                        }
                    case 1:
                        if (getRow() > 0 && getCol() < 7 && !(ChessBoard.emptyCell.equals(board[getCol() + 1][getRow() - 1])) && board[getCol() + 1][getRow() - 1].charAt(1) == ChessBoard.whiteFigureCell) {
                            board[getCol() + 1][getRow() - 1] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + 1);
                            setRow(getRow() - 1);
                            return board;
                        }
                    case 2:
                        if (getRow() < 7 && getCol() < 7 && !board[getCol() + 1][getRow() + 1].equals(ChessBoard.emptyCell) && board[getCol() + 1][getRow() + 1].charAt(1) == ChessBoard.whiteFigureCell) {
                            board[getCol() + 1][getRow() + 1] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + 1);
                            setRow(getRow() + 1);
                            return board;
                        }
                }
            }
        }
        return board;

    }
}
