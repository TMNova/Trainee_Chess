package ru.lanit.board;

import java.util.Arrays;
import java.util.Random;
import ru.lanit.figures.*;

public class ChessBoard {
    private String[][] board;
    private Pawn[] pawnWhite = new Pawn[8];
    private Pawn[] pawnBlack = new Pawn[8];
    private Bishop[] bishopWhite = new Bishop[2];
    private Bishop[] bishopBlack = new Bishop[2];
    private Rook[] rookWhite = new Rook[2];
    private Rook[] rookBlack = new Rook[2];
    private Castle[] castleWhite = new Castle[2];
    private Castle[] castleBlack = new Castle[2];
    private King kingWhite = new King(true);
    private King kingBlack = new King(false);
    private Queen queenWhite = new Queen(true);
    private Queen queenBlack = new Queen(false);
    private String[][] cloneChessBoard;
    private Random random = new Random();
    public static final String emptyCell = "-";
    public static final char whiteFigureCell = 'W';
    public static final char blackFigureCell = 'B';


    public ChessBoard() {
        board = new String[8][8];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = emptyCell;
            }
        }
    }

    private void fillBoardFigures(String[][] board) {
        for (int i = 0; i < pawnWhite.length; i++) {
            pawnWhite[i] = new Pawn(true);
            pawnWhite[i].fillBoard(board);
            pawnBlack[i] = new Pawn(false);
            pawnBlack[i].fillBoard(board);
        }
        for (int i = 0; i < bishopWhite.length; i++) {
            bishopWhite[i] = new Bishop(true);
            bishopWhite[i].fillBoard(board);
            bishopBlack[i] = new Bishop(false);
            bishopBlack[i].fillBoard(board);
            rookWhite[i] = new Rook(true);
            rookWhite[i].fillBoard(board);
            rookBlack[i] = new Rook(false);
            rookBlack[i].fillBoard(board);
            castleWhite[i] = new Castle(true);
            castleWhite[i].fillBoard(board);
            castleBlack[i] = new Castle(false);
            castleBlack[i].fillBoard(board);
        }
        kingWhite.fillBoard(board);
        kingBlack.fillBoard(board);
        queenWhite.fillBoard(board);
        queenBlack.fillBoard(board);
        
    }


    public void createAndFillChessBoard() {
        fillBoardFigures(board);
        cloneChessBoard = cloneBoard(board);
    }

    public void playChess() {
        while (true) {
            stepWhiteFigures();
            showBoard(board);
            cloneChessBoard = cloneBoard(board);
            if (cantMove()) break;

            stepBlackFigures();
            showBoard(board);
            cloneChessBoard = cloneBoard(board);
            if (cantMove()) break;
        }
    }

    private void stepWhiteFigures() {
        while (Arrays.deepEquals(board, cloneChessBoard)) {
            int rand = random.nextInt(6);
            int rand2 = 0;
            switch (rand) {
                case 0:
                    rand2 = random.nextInt(8);
                    if (pawnWhite[rand2].canMove(board)) {
                        pawnWhite[rand2].move(board);
                        break;
                    }
                case 1:
                    rand2 = random.nextInt(2);
                    if (bishopWhite[rand2].canMove(board)) {
                        bishopWhite[rand2].move(board);
                        break;
                    }
                case 2:
                    rand2 = random.nextInt(2);
                    if (rookWhite[rand2].canMove(board)) {
                        rookWhite[rand2].move(board);
                        break;
                    }
                case 3:
                    rand2 = random.nextInt(2);
                    if (castleWhite[rand2].canMove(board)) {
                        castleWhite[rand2].move(board);
                        break;
                    }
                case 4:
                    if (kingWhite.canMove(board)) {
                        kingWhite.move(board);
                        break;
                    }
                case 5:
                    if (queenWhite.canMove(board)) {
                        queenWhite.move(board);
                        break;
                    }
            }
        }
    }

    private void stepBlackFigures() {
        while (Arrays.deepEquals(cloneChessBoard, board)) {
            int rand = random.nextInt(6);
            switch (rand) {
                case 0:
                    int rand2 = random.nextInt(8);
                    if (pawnBlack[rand2].canMove(board)) {
                        pawnBlack[rand2].move(board);
                        break;
                    }
                case 1:
                    rand2 = random.nextInt(2);
                    if (bishopBlack[rand2].canMove(board)) {
                        bishopBlack[rand2].move(board);
                        break;
                    }
                case 2:
                    rand2 = random.nextInt(2);
                    if (rookBlack[rand2].canMove(board)) {
                        rookBlack[rand2].move(board);
                        break;
                    }
                case 3:
                    rand2 = random.nextInt(2);
                    if (castleBlack[rand2].canMove(board)) {
                        castleBlack[rand2].move(board);
                        break;
                    }
                case 4:
                    if (kingBlack.canMove(board)) {
                        kingBlack.move(board);
                        break;
                    }
                case 5:
                    if (queenBlack.canMove(board)) {
                        queenBlack.move(board);
                        break;
                    }
            }
        }
    }

    private boolean cantMove() {
        return (!(pawnWhite[0].canMove(board) || pawnWhite[1].canMove(board) || pawnWhite[2].canMove(board) || pawnWhite[3].canMove(board)
                || pawnWhite[4].canMove(board) || pawnWhite[5].canMove(board) || pawnWhite[6].canMove(board) || pawnWhite[7].canMove(board)
                || bishopWhite[0].canMove(board) || bishopWhite[1].canMove(board) || rookWhite[0].canMove(board) || rookWhite[1].canMove(board)
                || castleWhite[0].canMove(board) || castleWhite[1].canMove(board) || kingWhite.canMove(board) || queenWhite.canMove(board)))
                || (!(pawnBlack[0].canMove(board) || pawnBlack[1].canMove(board) || pawnBlack[2].canMove(board) || pawnBlack[3].canMove(board)
                || pawnBlack[4].canMove(board) || pawnBlack[5].canMove(board) || pawnBlack[6].canMove(board) || pawnBlack[7].canMove(board)
                || bishopBlack[0].canMove(board) || bishopBlack[1].canMove(board) || rookBlack[0].canMove(board) || rookBlack[1].canMove(board)
                || castleBlack[0].canMove(board) || castleBlack[1].canMove(board) || kingBlack.canMove(board) || queenBlack.canMove(board)));
    }

    String[][] cloneBoard(String[][] board) {
        String[][] cloneChessBoard = new String[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                cloneChessBoard[i][j] = board[i][j];
            }
        }
        return cloneChessBoard;
    }

    void showBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}