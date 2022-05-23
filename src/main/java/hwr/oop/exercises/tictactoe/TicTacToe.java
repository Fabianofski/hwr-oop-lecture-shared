package hwr.oop.exercises.tictactoe;

class TicTacToe {

    int[][][] board;
    boolean gameStarted;
    boolean crossTurn = false;
    boolean playIn3D;
    int boardSize;

    TicTacToe(int boardSize, boolean playIn3D) {
        this.boardSize = boardSize;
        this.playIn3D = playIn3D;
        board = new int[boardSize][boardSize][playIn3D ? boardSize : 1];
    }

    int getValueAt(int x, int y, int z) {
        return board[x][y][z];
    }

    void setCross(int x, int y, int z) {
        if (!gameStarted) crossTurn = true;
        if (isGameOver()) throw new RuntimeException("Game is Over!");
        if (!crossTurn) throw new RuntimeException("It's not Player As' Turn");
        if (board[x][y][z] != 0) throw new RuntimeException("Cannot toe a spot twice!");
        gameStarted = true;

        board[x][y][z] = 1;
        crossTurn = false;

    }

    void setCircle(int x, int y, int z) {
        if (!gameStarted) crossTurn = false;
        if (isGameOver()) throw new RuntimeException("Game is Over!");
        if (crossTurn) throw new RuntimeException("It's not Player Bs' Turn");
        if (board[x][y][z] != 0) throw new RuntimeException("Cannot toe a spot twice!");

        board[x][y][z] = 2;
        crossTurn = true;

        gameStarted = true;
    }

    boolean isGameOver() {

        if (checkRows()) {
            System.out.println("Row complete");
            return true;
        }
        if (checkColumns()) {
            System.out.println("Column complete");
            return true;
        }
        if (checkDiagonals()) {
            System.out.println("Diagonal complete");
            return true;
        }
        if (playIn3D && checkDepth()) {
            System.out.println("Depth complete");
            return true;
        }
        if (playIn3D && checkDepthDiagonal()) {
            System.out.println("DepthDiagonal complete");
            return true;
        }
        return false;
    }

    private boolean checkDepthDiagonal() {
        boolean row = true;
        for (int y = 1; y < boardSize; y++) {
            row = board[2 - y][y][y] == board[3 - y][y - 1][y - 1] && board[2 - y][y][y] != 0;
            if (!row) break;
        }
        if (row) return true;
        row = true;
        for (int y = 1; y < boardSize; y++) {
            row = board[y][y][y] == board[y - 1][y - 1][y - 1] && board[y][y][y] != 0;
            if (!row) break;
        }
        return row;
    }

    boolean checkColumns() {
        for (int z = 0; z < (playIn3D ? boardSize : 1); z++) {
            for (int x = 0; x < boardSize; x++) {
                boolean row = true;
                for (int y = 1; y < boardSize; y++) {
                    row = board[x][y][z] == board[x][y - 1][z] && board[x][y][z] != 0;
                    if (!row) break;
                }
                if (row) return true;
            }
        }
        return false;
    }

    boolean checkRows() {
        for (int z = 0; z < (playIn3D ? boardSize : 1); z++) {
            for (int y = 0; y < boardSize; y++) {
                boolean row = true;
                for (int x = 1; x < boardSize; x++) {
                    row = board[x][y][z] == board[x - 1][y][z] && board[x][y][z] != 0;
                    if (!row) break;
                }
                if (row) return true;
            }
        }
        return false;
    }

    boolean checkDiagonals() {
        boolean row = true;
        for (int z = 0; z < (playIn3D ? boardSize : 1); z++) {
            for (int y = 1; y < boardSize; y++) {
                row = board[2 - y][y][z] == board[3 - y][y - 1][z] && board[2 - y][y][z] != 0;
                if (!row) break;
            }
        }
        if (row) return true;

        row = true;
        for (int z = 0; z < (playIn3D ? boardSize : 1); z++) {
            for (int y = 1; y < boardSize; y++) {
                row = board[y][y][z] == board[y - 1][y - 1][z] && board[y][y][z] != 0;
                if (!row) break;
            }
        }
        return row;
    }

    boolean checkDepth() {
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                boolean row = true;
                for (int z = 1; z < (playIn3D ? boardSize : 1); z++) {
                    row = board[x][y][z] == board[x][y][z - 1] && board[x][y][z] != 0;
                    if (!row) break;
                }
                if (row) return true;
            }
        }
        return false;
    }
}
