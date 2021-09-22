package ru.lanit;

import ru.lanit.board.ChessBoard;
import ru.lanit.figures.*;

public class Main {
    public static void main(String[] args) {
        ChessBoard c = new ChessBoard(8, 8);
        c.create();
    }
}