package ru.lanit.figures;

import ru.lanit.board.ChessBoard;

import org.apache.commons.lang3.RandomUtils;


public class Castle extends Figure {
    private RandomUtils random = new RandomUtils();

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
            if (ChessBoard.emptyCell.equals(board[7][0])) {
                board[7][0] = getType();
                setCol(7);
                setRow(0);
                return board;
            } else if (ChessBoard.emptyCell.equals(board[7][7])) {
                board[7][7] = getType();
                setCol(7);
                setRow(7);
                return board;
            }
        } else {
            if (ChessBoard.emptyCell.equals(board[0][0])) {
                board[0][0] = getType();
                setCol(0);
                setRow(0);
                return board;
            } else if (ChessBoard.emptyCell.equals(board[0][7])) {
                board[0][7] = getType();
                setCol(0);
                setRow(7);
                return board;
            }
        }
        return board;
    }

    @Override
    public boolean canMove(String[][] board) {
        if (!board[getCol()][getRow()].equals(getType())) return false;
        if (isWhite()) {
            return (getCol() < 7 && (ChessBoard.emptyCell.equals(board[getCol() + 1][getRow()]) || board[getCol() + 1][getRow()].charAt(1) == ChessBoard.blackFigureCell))
                    || (getCol() > 0 && (ChessBoard.emptyCell.equals(board[getCol() - 1][getRow()]) || board[getCol() - 1][getRow()].charAt(1) == ChessBoard.blackFigureCell))
                    || (getRow() < 7 && (ChessBoard.emptyCell.equals(board[getCol()][getRow() + 1]) || board[getCol()][getRow() + 1].charAt(1) == ChessBoard.blackFigureCell))
                    || (getRow() > 0 && (ChessBoard.emptyCell.equals(board[getCol()][getRow() - 1]) || board[getCol()][getRow() - 1].charAt(1) == ChessBoard.blackFigureCell));
        } else {
            return (getCol() < 7 && (ChessBoard.emptyCell.equals(board[getCol() + 1][getRow()]) || board[getCol() + 1][getRow()].charAt(1) == ChessBoard.whiteFigureCell))
                    || (getCol() > 0 && (ChessBoard.emptyCell.equals(board[getCol() - 1][getRow()]) || board[getCol() - 1][getRow()].charAt(1) == ChessBoard.whiteFigureCell))
                    || (getRow() < 7 && (ChessBoard.emptyCell.equals(board[getCol()][getRow() + 1]) || board[getCol()][getRow() + 1].charAt(1) == ChessBoard.whiteFigureCell))
                    || (getRow() > 0 && (ChessBoard.emptyCell.equals(board[getCol()][getRow() - 1]) || board[getCol()][getRow() - 1].charAt(1) == ChessBoard.whiteFigureCell));
        }
    }

    @Override
    public String[][] move(String[][] board) {
        if (isWhite()) {
            int cloneCol = getCol();
            int cloneRow = getRow();
            while (cloneCol == getCol() && cloneRow == getRow()) {
                int rand = random.nextInt(0, 4);
                int rand2 = random.nextInt(0, 8);
                switch (rand) {
                    case 0:
                        if ((getCol() + rand2 < 7 && (ChessBoard.emptyCell.equals(board[getCol() + rand2][getRow()]) || board[getCol() + rand2][getRow()].charAt(1) == ChessBoard.blackFigureCell))) {
                            board[getCol() + rand2][getRow()] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + rand2);
                            setRow(getRow());
                            return board;
                        }
                    case 1:
                        if ((getCol() - rand2 > 0 && (ChessBoard.emptyCell.equals(board[getCol() - rand2][getRow()]) || board[getCol() - rand2][getRow()].charAt(1) == ChessBoard.blackFigureCell))) {
                            board[getCol() - rand2][getRow()] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - rand2);
                            setRow(getRow());
                            return board;
                        }
                    case 2:
                        if ((getRow() - rand2 > 0 && (ChessBoard.emptyCell.equals(board[getCol()][getRow() - rand2]) || board[getCol()][getRow() - rand2].charAt(1) == ChessBoard.blackFigureCell))) {
                            board[getCol()][getRow() - rand2] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol());
                            setRow(getRow() - rand2);
                            return board;
                        }
                    case 3:
                        if ((getRow() + rand2 < 7 && (ChessBoard.emptyCell.equals(board[getCol()][getRow() + rand2]) || board[getCol()][getRow() + rand2].charAt(1) == ChessBoard.blackFigureCell))) {
                            board[getCol()][getRow() + rand2] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol());
                            setRow(getRow() + rand2);
                            return board;
                        }
                }
            }
        } else {
            int cloneCol = getCol();
            int cloneRow = getRow();
            while (cloneCol == getCol() && cloneRow == getRow()) {
                int rand = random.nextInt(0, 4);
                int rand2 = random.nextInt(0, 8);
                switch (rand) {
                    case 0:
                        if ((getCol() + rand2 < 7 && (ChessBoard.emptyCell.equals(board[getCol() + rand2][getRow()]) || board[getCol() + rand2][getRow()].charAt(1) == ChessBoard.whiteFigureCell))) {
                            board[getCol() + rand2][getRow()] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() + rand2);
                            setRow(getRow());
                            return board;
                        }
                    case 1:
                        if ((getCol() - rand2 > 0 && (ChessBoard.emptyCell.equals(board[getCol() - rand2][getRow()]) || board[getCol() - rand2][getRow()].charAt(1) == ChessBoard.whiteFigureCell))) {
                            board[getCol() - rand2][getRow()] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol() - rand2);
                            setRow(getRow());
                            return board;
                        }
                    case 2:
                        if ((getRow() - rand2 > 0 && (ChessBoard.emptyCell.equals(board[getCol()][getRow() - rand2]) || board[getCol()][getRow() - rand2].charAt(1) == ChessBoard.whiteFigureCell))) {
                            board[getCol()][getRow() - rand2] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol());
                            setRow(getRow() - rand2);
                            return board;
                        }
                    case 3:
                        if ((getRow() + rand2 < 7 && (ChessBoard.emptyCell.equals(board[getCol()][getRow() + rand2]) || board[getCol()][getRow() + rand2].charAt(1) == ChessBoard.whiteFigureCell))) {
                            board[getCol()][getRow() + rand2] = getType();
                            board[getCol()][getRow()] = ChessBoard.emptyCell;
                            setCol(getCol());
                            setRow(getRow() + rand2);
                            return board;
                        }
                }
            }
        }
        return board;
    }
}
