package ru.lanit.figures;

import ru.lanit.board.ChessBoard;

import java.util.Random;


public class Queen extends Figure {
    Random random = new Random();
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
            setCol(7);
            setRow(3);
            return board;
        } else {
            board[0][3] = getType();
            setCol(0);
            setRow(3);
            return board;
        }
    }

    @Override
    public boolean canMove(String[][] board) {
        if (isWhite()) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getCol() + STEPS[i][0] < 7 && getCol() + STEPS[i][0] > 0 && getRow() + STEPS[i][1] < 7 && getRow() + STEPS[i][1] > 0
                        && (ChessBoard.emptyCell.equals(board[getCol() + STEPS[i][0]][getRow() + STEPS[i][1]])
                        || (board[getCol() + STEPS[i][0]][getRow() + STEPS[i][1]]).charAt(1) == ChessBoard.blackFigureCell)) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < STEPS.length; i++) {
                if (getCol() + STEPS[i][0] < 7 && getCol() + STEPS[i][0] > 0 && getRow() + STEPS[i][1] < 7 && getRow() + STEPS[i][1] > 0
                        && (ChessBoard.emptyCell.equals(board[getCol() + STEPS[i][0]][getRow() + STEPS[i][1]])
                        || (board[getCol() + STEPS[i][0]][getRow() + STEPS[i][1]]).charAt(1) == ChessBoard.whiteFigureCell)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String[][] move(String[][] board) {
        if (isWhite() && canMove(board)) {
            int cloneCol = getCol();
            int cloneRow = getRow();
            while (cloneCol == getCol() && cloneRow == getRow()) {
                int colSteps = random.nextInt(8);
                if ((getCol() + STEPS[colSteps][0] > 0 && getCol() + STEPS[colSteps][0] < 7
                        && getRow() + STEPS[colSteps][1] > 0 && getRow() + STEPS[colSteps][1] < 7)
                        && (ChessBoard.emptyCell.equals(board[getCol() + STEPS[colSteps][0]][getRow() + STEPS[colSteps][1]])
                        || (board[getCol() + STEPS[colSteps][0]][getRow() + STEPS[colSteps][1]]).charAt(1) == ChessBoard.blackFigureCell)) {
                    board[getCol() + STEPS[colSteps][0]][getRow() + STEPS[colSteps][1]] = getType();
                    board[getCol()][getRow()] = ChessBoard.emptyCell;
                    setCol(getCol() + STEPS[colSteps][0]);
                    setRow(getRow() + STEPS[colSteps][1]);
                    return board;
                }
            }
        } else if (!(isWhite()) && canMove(board)) {
            int cloneCol = getCol();
            int cloneRow = getRow();
            while (cloneCol == getCol() && cloneRow == getRow()) {
                int colSteps = random.nextInt(8);
                if ((getCol() + STEPS[colSteps][0] > 0 && getCol() + STEPS[colSteps][0] < 7
                        && getRow() + STEPS[colSteps][1] > 0 && getRow() + STEPS[colSteps][1] < 7)
                        && (ChessBoard.emptyCell.equals(board[getCol() + STEPS[colSteps][0]][getRow() + STEPS[colSteps][1]])
                        || (board[getCol() + STEPS[colSteps][0]][getRow() + STEPS[colSteps][1]]).charAt(1) == ChessBoard.whiteFigureCell)) {
                    board[getCol() + STEPS[colSteps][0]][getRow() + STEPS[colSteps][1]] = getType();
                    board[getCol()][getRow()] = ChessBoard.emptyCell;
                    setCol(getCol() + STEPS[colSteps][0]);
                    setRow(getRow() + STEPS[colSteps][1]);
                    return board;
                }
            }

        }
        return board;

    }

}