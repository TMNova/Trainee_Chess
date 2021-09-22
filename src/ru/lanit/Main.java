package ru.lanit;

import ru.lanit.board.ChessBoard;

public class Main {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.createAndFillChessBoard();
        chessBoard.playChess();
    }
}