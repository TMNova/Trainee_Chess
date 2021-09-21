import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ChessBoard c = new ChessBoard(8, 8);
        c.create();
    }
}

class ChessBoard {
    private int sizeX;
    private int sizeY;
    private String[][] board;

    ChessBoard(int sizeX, int sizeY) {
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

    void create() {
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

abstract class Figure {
    private int x;
    private int y;
    private boolean isWhite;
    private String type;

    void setType(String type) {
        this.type = type;
    }

    String getType() {
        return type;
    }

    void setWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    boolean isWhite() {
        return isWhite;
    }

    void setX(int x) {
        this.x = x;
    }

    int getX() {
        return x;
    }

    void setY(int y) {
        this.y = y;
    }

    int getY() {
        return y;
    }

    abstract String[][] fillBoard(String[][] board);

    abstract boolean canMove(String[][] board);

    abstract String[][] move(String[][] board);

}

class Pawn extends Figure {
    Random r = new Random();

    Pawn(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("PW");
        } else {
            setType("PB");
        }
    }

    @Override
    String[][] fillBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            if ("-".equals(board[6][i]) && isWhite()) {
                board[6][i] = getType();
                setX(6);
                setY(i);
                return board;
            } else if ("-".equals(board[1][i]) && !(isWhite())) {
                board[1][i] = getType();
                setX(1);
                setY(i);
                return board;
            }
        }
        return board;
    }

    @Override
    boolean canMove(String[][] board) {
        String a = isWhite() ? "true" : "false";
        switch (a) {
            case "true":
                if (getX() == 0) {
                    return false;
                }
                if (!board[getX() - 1][getY()].equals("-") && board[getX() - 1][getY()].charAt(1) == 'W') return false;
                if (getX() > 0 && getType().equals(board[getX()][getY()])) {
                    return ("-".equals(board[getX() - 1][getY()]))
                            || (getY() > 0 && !board[getX() - 1][getY() - 1].equals("-") && !board[getX() - 1][getY() - 1].equals("PW"))
                            || (getY() < 7 && !board[getX() - 1][getY() + 1].equals("-") && !board[getX() - 1][getY() + 1].equals("PW"));
                }
            case "false":
                if (getX() == 7) {
                    return false;
                }
                if (!board[getX() + 1][getY()].equals("-") && board[getX() + 1][getY()].charAt(1) == 'B') return false;

                if (getX() < 7 && board[getX()][getY()].equals(getType())) {
                    return ("-".equals(board[getX() + 1][getY()]))
                            || (getY() > 0 && !board[getX() + 1][getY() - 1].equals("-") && !board[getX() + 1][getY() - 1].equals("PB"))
                            || (getY() < 7 && !board[getX() + 1][getY() + 1].equals("-") && !board[getX() + 1][getY() + 1].equals("PB"));
                }
        }
        return false;
    }

    @Override
    String[][] move(String[][] board) {
        if (!(canMove(board))) return board;
        if (isWhite()) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = r.nextInt(3);
                switch (rand) {
                    case 0:
                        if (getX() > 0 && (!board[getX() - 1][getY()].equals("-") && board[getX() - 1][getY()].charAt(1) != 'W') || board[getX() - 1][getY()].equals("-")) {
                            board[getX() - 1][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - 1);
                            setY(getY());
                            return board;
                        }
                    case 1:
                        if (getY() > 0 && getX() > 0 && !board[getX() - 1][getY() - 1].equals("-") && board[getX() - 1][getY() - 1].charAt(1) == 'B') {
                            board[getX() - 1][getY() - 1] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - 1);
                            setY(getY() - 1);
                            return board;
                        }
                    case 2:
                        if (getY() < 7 && getX() > 0 && !board[getX() - 1][getY() + 1].equals("-") && board[getX() - 1][getY() + 1].charAt(1) == 'B') {
                            board[getX() - 1][getY() + 1] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - 1);
                            setY(getY() + 1);
                            return board;
                        }
                }
            }
        } else if (!(isWhite())) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = r.nextInt(3);
                switch (rand) {
                    case 0:
                        if (getX() < 7 && (!board[getX() + 1][getY()].equals("-") && board[getX() + 1][getY()].charAt(1) != 'B') || board[getX() + 1][getY()].equals("-")) {
                            board[getX() + 1][getY()] = "PB";
                            board[getX()][getY()] = "-";
                            setX(getX() + 1);
                            setY(getY());
                            return board;
                        }
                    case 1:
                        if (getY() > 0 && getX() < 7 && !("-".equals(board[getX() + 1][getY() - 1])) && board[getX() + 1][getY() - 1].charAt(1) == 'W') {
                            board[getX() + 1][getY() - 1] = "PB";
                            board[getX()][getY()] = "-";
                            setX(getX() + 1);
                            setY(getY() - 1);
                            return board;
                        }
                    case 2:
                        if (getY() < 7 && getX() < 7 && !board[getX() + 1][getY() + 1].equals("-") && board[getX() + 1][getY() + 1].charAt(1) == 'W') {
                            board[getX() + 1][getY() + 1] = "PB";
                            board[getX()][getY()] = "-";
                            setX(getX() + 1);
                            setY(getY() + 1);
                            return board;
                        }
                }
            }
        }
        return board;

    }
}

class Bishop extends Figure {
    Random r = new Random();

    Bishop(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("BW");
        } else {
            setType("BB");
        }
    }

    @Override
    String[][] fillBoard(String[][] board) {
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
    boolean canMove(String[][] board) {
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
    String[][] move(String[][] board) {
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

class Rook extends Figure {
    Random r = new Random();
    final byte[][] STEPS = new byte[][]{
            {2, 1},
            {2, -1},
            {1, 2},
            {1, -2},
            {-2, 1},
            {-2, -1},
            {-1, 2},
            {-1, -2}
    };

    Rook(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("RW");
        } else {
            setType("RB");
        }
    }

    @Override
    String[][] fillBoard(String[][] board) {
        if (isWhite()) {
            if ("-".equals(board[7][1])) {
                board[7][1] = getType();
                setX(7);
                setY(1);
                return board;
            } else if ("-".equals(board[7][6])) {
                board[7][6] = getType();
                setX(7);
                setY(6);
                return board;
            }
        } else if (!(isWhite())) {
            if ("-".equals(board[0][1])) {
                board[0][1] = getType();
                setX(0);
                setY(1);
                return board;
            } else if ("-".equals(board[0][6])) {
                board[0][6] = getType();
                setX(0);
                setY(6);
                return board;
            }
        }
        return board;
    }

    @Override
    boolean canMove(String[][] board) {
        if (!board[getX()][getY()].equals(getType())) return false;
        if (isWhite()) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getX() + STEPS[i][0] < 7 && getX() + STEPS[i][0] > 0 && getY() + STEPS[i][1] < 7 && getY() + STEPS[i][1] > 0
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'B')) {
                    return true;
                }
            }
            return false;
        } else if (!(isWhite())) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getX() + STEPS[i][0] < 7 && getX() + STEPS[i][0] > 0 && getY() + STEPS[i][1] < 7 && getY() + STEPS[i][1] > 0
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'W')) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    String[][] move(String[][] board) {
        if (isWhite() && canMove(board)) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int i = r.nextInt(8);
                if ((getX() + STEPS[i][0] > 0 && getX() + STEPS[i][0] < 7
                        && getY() + STEPS[i][1] > 0 && getY() + STEPS[i][1] < 7)
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'B')) {
                    board[getX() + STEPS[i][0]][getY() + STEPS[i][1]] = getType();
                    board[getX()][getY()] = "-";
                    setX(getX() + STEPS[i][0]);
                    setY(getY() + STEPS[i][1]);
                    return board;
                }
            }
        } else if (!(isWhite()) && canMove(board)) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int i = r.nextInt(8);
                if ((getX() + STEPS[i][0] > 0 && getX() + STEPS[i][0] < 7
                        && getY() + STEPS[i][1] > 0 && getY() + STEPS[i][1] < 7)
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'W')) {
                    board[getX() + STEPS[i][0]][getY() + STEPS[i][1]] = getType();
                    board[getX()][getY()] = "-";
                    setX(getX() + STEPS[i][0]);
                    setY(getY() + STEPS[i][1]);
                    return board;
                }
            }

        }
        return board;
    }
}

class Castle extends Figure {
    Random r = new Random();

    Castle(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("CW");
        } else {
            setType("CB");
        }
    }

    @Override
    String[][] fillBoard(String[][] board) {
        if (isWhite()) {
            if ("-".equals(board[7][0])) {
                board[7][0] = getType();
                setX(7);
                setY(0);
                return board;
            } else if ("-".equals(board[7][7])) {
                board[7][7] = getType();
                setX(7);
                setY(7);
                return board;
            }
        } else if (!(isWhite())) {
            if ("-".equals(board[0][0])) {
                board[0][0] = getType();
                setX(0);
                setY(0);
                return board;
            } else if ("-".equals(board[0][7])) {
                board[0][7] = getType();
                setX(0);
                setY(7);
                return board;
            }
        }
        return board;
    }

    @Override
    boolean canMove(String[][] board) {
        if (!board[getX()][getY()].equals(getType())) return false;
        if (isWhite()) {
            return (getX() < 7 && ("-".equals(board[getX() + 1][getY()]) || board[getX() + 1][getY()].charAt(1) == 'B'))
                    || (getX() > 0 && ("-".equals(board[getX() - 1][getY()]) || board[getX() - 1][getY()].charAt(1) == 'B'))
                    || (getY() < 7 && ("-".equals(board[getX()][getY() + 1]) || board[getX()][getY() + 1].charAt(1) == 'B'))
                    || (getY() > 0 && ("-".equals(board[getX()][getY() - 1]) || board[getX()][getY() - 1].charAt(1) == 'B'));
        } else if (!(isWhite())) {
            return (getX() < 7 && ("-".equals(board[getX() + 1][getY()]) || board[getX() + 1][getY()].charAt(1) == 'W'))
                    || (getX() > 0 && ("-".equals(board[getX() - 1][getY()]) || board[getX() - 1][getY()].charAt(1) == 'W'))
                    || (getY() < 7 && ("-".equals(board[getX()][getY() + 1]) || board[getX()][getY() + 1].charAt(1) == 'W'))
                    || (getY() > 0 && ("-".equals(board[getX()][getY() - 1]) || board[getX()][getY() - 1].charAt(1) == 'W'));
        }

        return false;
    }

    @Override
    String[][] move(String[][] board) {
        if (isWhite()) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = r.nextInt(4);
                int rand2 = r.nextInt(8);
                switch (rand) {
                    case 0:
                        if ((getX() + rand2 < 7 && ("-".equals(board[getX() + rand2][getY()]) || board[getX() + rand2][getY()].charAt(1) == 'B'))) {
                            board[getX() + rand2][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() + rand2);
                            setY(getY());
                            return board;
                        }
                    case 1:
                        if ((getX() - rand2 > 0 && ("-".equals(board[getX() - rand2][getY()]) || board[getX() - rand2][getY()].charAt(1) == 'B'))) {
                            board[getX() - rand2][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - rand2);
                            setY(getY());
                            return board;
                        }
                    case 2:
                        if ((getY() - rand2 > 0 && ("-".equals(board[getX()][getY() - rand2]) || board[getX()][getY() - rand2].charAt(1) == 'B'))) {
                            board[getX()][getY() - rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX());
                            setY(getY() - rand2);
                            return board;
                        }
                    case 3:
                        if ((getY() + rand2 < 7 && ("-".equals(board[getX()][getY() + rand2]) || board[getX()][getY() + rand2].charAt(1) == 'B'))) {
                            board[getX()][getY() + rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX());
                            setY(getY() + rand2);
                            return board;
                        }
                }
            }
        } else if (!(isWhite())) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int rand = r.nextInt(4);
                int rand2 = r.nextInt(8);
                switch (rand) {
                    case 0:
                        if ((getX() + rand2 < 7 && ("-".equals(board[getX() + rand2][getY()]) || board[getX() + rand2][getY()].charAt(1) == 'W'))) {
                            board[getX() + rand2][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() + rand2);
                            setY(getY());
                            return board;
                        }
                    case 1:
                        if ((getX() - rand2 > 0 && ("-".equals(board[getX() - rand2][getY()]) || board[getX() - rand2][getY()].charAt(1) == 'W'))) {
                            board[getX() - rand2][getY()] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX() - rand2);
                            setY(getY());
                            return board;
                        }
                    case 2:
                        if ((getY() - rand2 > 0 && ("-".equals(board[getX()][getY() - rand2]) || board[getX()][getY() - rand2].charAt(1) == 'W'))) {
                            board[getX()][getY() - rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX());
                            setY(getY() - rand2);
                            return board;
                        }
                    case 3:
                        if ((getY() + rand2 < 7 && ("-".equals(board[getX()][getY() + rand2]) || board[getX()][getY() + rand2].charAt(1) == 'W'))) {
                            board[getX()][getY() + rand2] = getType();
                            board[getX()][getY()] = "-";
                            setX(getX());
                            setY(getY() + rand2);
                            return board;
                        }
                }
            }
        }
        return board;
    }

}

class King extends Figure {
    Random r = new Random();
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

    King(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("KW");
        } else {
            setType("KB");
        }
    }

    @Override
    String[][] fillBoard(String[][] board) {
        if (isWhite()) {
            board[7][4] = getType();
            setX(7);
            setY(4);
            return board;
        } else if (!(isWhite())) {
            board[0][4] = getType();
            setX(0);
            setY(4);
            return board;
        }
        return board;
    }

    @Override
    boolean canMove(String[][] board) {
        if (isWhite()) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getX() + STEPS[i][0] < 7 && getX() + STEPS[i][0] > 0 && getY() + STEPS[i][1] < 7 && getY() + STEPS[i][1] > 0
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'B')) {
                    return true;
                }
            }
            return false;
        } else if (!(isWhite())) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getX() + STEPS[i][0] < 7 && getX() + STEPS[i][0] > 0 && getY() + STEPS[i][1] < 7 && getY() + STEPS[i][1] > 0
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'W')) {
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    String[][] move(String[][] board) {
        if (isWhite() && canMove(board)) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int i = r.nextInt(8);
                if ((getX() + STEPS[i][0] > 0 && getX() + STEPS[i][0] < 7
                        && getY() + STEPS[i][1] > 0 && getY() + STEPS[i][1] < 7)
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'B')) {
                    board[getX() + STEPS[i][0]][getY() + STEPS[i][1]] = getType();
                    board[getX()][getY()] = "-";
                    setX(getX() + STEPS[i][0]);
                    setY(getY() + STEPS[i][1]);
                    return board;
                }
            }
        } else if (!(isWhite()) && canMove(board)) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int i = r.nextInt(8);
                if ((getX() + STEPS[i][0] > 0 && getX() + STEPS[i][0] < 7
                        && getY() + STEPS[i][1] > 0 && getY() + STEPS[i][1] < 7)
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'W')) {
                    board[getX() + STEPS[i][0]][getY() + STEPS[i][1]] = getType();
                    board[getX()][getY()] = "-";
                    setX(getX() + STEPS[i][0]);
                    setY(getY() + STEPS[i][1]);
                    return board;
                }
            }

        }
        return board;
    }

}

class Queen extends Figure {
    Random r = new Random();
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


    Queen(boolean isWhite) {
        setWhite(isWhite);
        if (isWhite()) {
            setType("QW");
        } else {
            setType("QB");
        }
    }

    @Override
    String[][] fillBoard(String[][] board) {
        if (isWhite()) {
            board[7][3] = getType();
            setX(7);
            setY(3);
            return board;
        } else if (!(isWhite())) {
            board[0][3] = getType();
            setX(0);
            setY(3);
            return board;
        }
        return board;
    }

    @Override
    boolean canMove(String[][] board) {
        if (isWhite()) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getX() + STEPS[i][0] < 7 && getX() + STEPS[i][0] > 0 && getY() + STEPS[i][1] < 7 && getY() + STEPS[i][1] > 0
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'B')) {
                    return true;
                }
            }
            return false;
        } else if (!(isWhite())) {
            for (int i = 0; i < STEPS.length; i++) {
                if (getX() + STEPS[i][0] < 7 && getX() + STEPS[i][0] > 0 && getY() + STEPS[i][1] < 7 && getY() + STEPS[i][1] > 0
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'W')) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    String[][] move(String[][] board) {
        if (isWhite() && canMove(board)) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int i = r.nextInt(8);
                if ((getX() + STEPS[i][0] > 0 && getX() + STEPS[i][0] < 7
                        && getY() + STEPS[i][1] > 0 && getY() + STEPS[i][1] < 7)
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'B')) {
                    board[getX() + STEPS[i][0]][getY() + STEPS[i][1]] = getType();
                    board[getX()][getY()] = "-";
                    setX(getX() + STEPS[i][0]);
                    setY(getY() + STEPS[i][1]);
                    return board;
                }
            }
        } else if (!(isWhite()) && canMove(board)) {
            int getX2 = getX();
            int getY2 = getY();
            while (getX2 == getX() && getY2 == getY()) {
                int i = r.nextInt(8);
                if ((getX() + STEPS[i][0] > 0 && getX() + STEPS[i][0] < 7
                        && getY() + STEPS[i][1] > 0 && getY() + STEPS[i][1] < 7)
                        && ("-".equals(board[getX() + STEPS[i][0]][getY() + STEPS[i][1]])
                        || (board[getX() + STEPS[i][0]][getY() + STEPS[i][1]]).charAt(1) == 'W')) {
                    board[getX() + STEPS[i][0]][getY() + STEPS[i][1]] = getType();
                    board[getX()][getY()] = "-";
                    setX(getX() + STEPS[i][0]);
                    setY(getY() + STEPS[i][1]);
                    return board;
                }
            }

        }
        return board;

    }

}