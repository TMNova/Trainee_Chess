package ru.lanit;

import ru.lanit.board.ChessBoard;

public class SecondMain {
    public static void main(String[] args) {
        System.out.println("Hello");
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.createAndFillChessBoard();
    }
}