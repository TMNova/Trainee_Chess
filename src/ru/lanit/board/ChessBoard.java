package ru.lanit.board;

import java.util.Arrays;
import java.util.Random;
import ru.lanit.figures.*;

public class ChessBoard {
    private int sizeX;
    private int sizeY;
    private String[][] board;

    public ChessBoard(int sizeX, int sizeY) {
        setSizeX(sizeX);
        setSizeY(sizeY);
        board = new String[sizeX][sizeY];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "-";
            }
        }
    }

    void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    int getSizeX() {
        return sizeX;
    }

    void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    int getSizeY() {
        return sizeY;
    }

    public void create() {
        Random r = new Random();

        Pawn[] pw = new Pawn[8];
        for (int i = 0; i < pw.length; i++) {
            pw[i] = new Pawn(true);
            pw[i].fillBoard(board);
        }
        Pawn[] pb = new Pawn[8];
        for (int i = 0; i < pb.length; i++) {
            pb[i] = new Pawn(false);
            pb[i].fillBoard(board);
        }

        Bishop[] bw = new Bishop[2];
        for (int i = 0; i < bw.length; i++) {
            bw[i] = new Bishop(true);
            bw[i].fillBoard(board);
        }
        Bishop[] bb = new Bishop[2];
        for (int i = 0; i < bb.length; i++) {
            bb[i] = new Bishop(false);
            bb[i].fillBoard(board);
        }

        Rook[] rw = new Rook[2];
        for (int i = 0; i < rw.length; i++) {
            rw[i] = new Rook(true);
            rw[i].fillBoard(board);
        }
        Rook[] rb = new Rook[2];
        for (int i = 0; i < rb.length; i++) {
            rb[i] = new Rook(false);
            rb[i].fillBoard(board);
        }

        Castle[] cw = new Castle[2];
        for (int i = 0; i < cw.length; i++) {
            cw[i] = new Castle(true);
            cw[i].fillBoard(board);
        }
        Castle[] cb = new Castle[2];
        for (int i = 0; i < cb.length; i++) {
            cb[i] = new Castle(false);
            cb[i].fillBoard(board);
        }

        King kw = new King(true);
        kw.fillBoard(board);
        King kb = new King(false);
        kb.fillBoard(board);

        Queen qw = new Queen(true);
        qw.fillBoard(board);
        Queen qb = new Queen(false);
        qb.fillBoard(board);

        String[][] tempBoard = fillTempBoard(board, getSizeX(), getSizeY());

        int it = 0;


        //simulating game
        while (true) {
            if (!(pw[0].canMove(board) || pw[1].canMove(board) || pw[2].canMove(board) || pw[3].canMove(board)
                    || pw[4].canMove(board) || pw[5].canMove(board) || pw[6].canMove(board) || pw[7].canMove(board)
                    || bw[0].canMove(board) || bw[1].canMove(board) || rw[0].canMove(board) || rw[1].canMove(board)
                    || cw[0].canMove(board) || cw[1].canMove(board) || kw.canMove(board) || qw.canMove(board))) {
                System.out.println("Game is over");
                break;
            }

            if (!(pb[0].canMove(board) || pb[1].canMove(board) || pb[2].canMove(board) || pb[3].canMove(board)
                    || pb[4].canMove(board) || pb[5].canMove(board) || pb[6].canMove(board) || pb[7].canMove(board)
                    || bb[0].canMove(board) || bb[1].canMove(board) || rb[0].canMove(board) || rb[1].canMove(board)
                    || cb[0].canMove(board) || cb[1].canMove(board) || kb.canMove(board) || qb.canMove(board))) {
                System.out.println("Game is over");
                break;
            }
            //white step
            while (Arrays.deepEquals(board, tempBoard)) {
                int rand = r.nextInt(6);
                int rand2 = 0;
                switch (rand) {
                    case 0:
                        rand2 = r.nextInt(8);
                        if (pw[rand2].canMove(board)) {
                            pw[rand2].move(board);
                            break;
                        }
                    case 1:
                        rand2 = r.nextInt(2);
                        if (bw[rand2].canMove(board)) {
                            bw[rand2].move(board);
                            break;
                        }
                    case 2:
                        rand2 = r.nextInt(2);
                        if (rw[rand2].canMove(board)) {
                            rw[rand2].move(board);
                            break;
                        }
                    case 3:
                        rand2 = r.nextInt(2);
                        if (cw[rand2].canMove(board)) {
                            cw[rand2].move(board);
                            break;
                        }
                    case 4:
                        if (kw.canMove(board)) {
                            kw.move(board);
                            break;
                        }
                    case 5:
                        if (qw.canMove(board)) {
                            qw.move(board);
                            break;
                        }
                }
            }
            showBoard(board);
            tempBoard = fillTempBoard(board, getSizeX(), getSizeY());

            if (!(pw[0].canMove(board) || pw[1].canMove(board) || pw[2].canMove(board) || pw[3].canMove(board)
                    || pw[4].canMove(board) || pw[5].canMove(board) || pw[6].canMove(board) || pw[7].canMove(board)
                    || bw[0].canMove(board) || bw[1].canMove(board) || rw[0].canMove(board) || rw[1].canMove(board)
                    || cw[0].canMove(board) || cw[1].canMove(board) || kw.canMove(board) || qw.canMove(board))) {
                System.out.println("Game is over");
                break;
            }

            if (!(pb[0].canMove(board) || pb[1].canMove(board) || pb[2].canMove(board) || pb[3].canMove(board)
                    || pb[4].canMove(board) || pb[5].canMove(board) || pb[6].canMove(board) || pb[7].canMove(board)
                    || bb[0].canMove(board) || bb[1].canMove(board) || rb[0].canMove(board) || rb[1].canMove(board)
                    || cb[0].canMove(board) || cb[1].canMove(board) || kb.canMove(board) || qb.canMove(board))) {
                System.out.println("Game is over");
                break;
            }
            //black step
            while (Arrays.deepEquals(tempBoard, board)) {
                int rand = r.nextInt(6);
                switch (rand) {
                    case 0:
                        int rand2 = r.nextInt(8);
                        if (pb[rand2].canMove(board)) {
                            pb[rand2].move(board);
                            break;
                        }
                    case 1:
                        rand2 = r.nextInt(2);
                        if (bb[rand2].canMove(board)) {
                            bb[rand2].move(board);
                            break;
                        }
                    case 2:
                        rand2 = r.nextInt(2);
                        if (rb[rand2].canMove(board)) {
                            rb[rand2].move(board);
                            break;
                        }
                    case 3:
                        rand2 = r.nextInt(2);
                        if (cb[rand2].canMove(board)) {
                            cb[rand2].move(board);
                            break;
                        }
                    case 4:
                        if (kb.canMove(board)) {
                            kb.move(board);
                            break;
                        }
                    case 5:
                        if (qb.canMove(board)) {
                            qb.move(board);
                            break;
                        }
                }
            }
            showBoard(board);
            tempBoard = fillTempBoard(board, getSizeX(), getSizeY());



            if (!(pw[0].canMove(board) || pw[1].canMove(board) || pw[2].canMove(board) || pw[3].canMove(board)
                    || pw[4].canMove(board) || pw[5].canMove(board) || pw[6].canMove(board) || pw[7].canMove(board)
                    || bw[0].canMove(board) || bw[1].canMove(board) || rw[0].canMove(board) || rw[1].canMove(board)
                    || cw[0].canMove(board) || cw[1].canMove(board) || kw.canMove(board) || qw.canMove(board))) {
                System.out.println("Game is over");
                break;
            }

            if (!(pb[0].canMove(board) || pb[1].canMove(board) || pb[2].canMove(board) || pb[3].canMove(board)
                    || pb[4].canMove(board) || pb[5].canMove(board) || pb[6].canMove(board) || pb[7].canMove(board)
                    || bb[0].canMove(board) || bb[1].canMove(board) || rb[0].canMove(board) || rb[1].canMove(board)
                    || cb[0].canMove(board) || cb[1].canMove(board) || kb.canMove(board) || qb.canMove(board))) {
                System.out.println("Game is over");
                break;
            }
        }




    }

    String[][] fillTempBoard(String[][] board, int sizeX, int sizeY) {
        String[][] tempBoard = new String[sizeX][sizeY];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }
        return tempBoard;
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