class TicTacToe {
    private char[][] matrix;
    private int[] horizontal1;
    private int[] vertial1;
    private int[] horizontal2;
    private int[] vertial2;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.matrix = new char[n][n];
        this.horizontal1 = new int[n];
        this.vertial2 = new int[n];
        this.horizontal2 = new int[n];
        this.vertial1 = new int[n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        switch (player) {
            case 1:
                matrix[row][col] = 'X';
                horizontal1[col]++;
                vertial1[row]++;
                break;
            case 2:
                matrix[row][col] = 'O';
                horizontal2[col]++;
                vertial2[row]++;
                break;
        }
        if (ok(player)) {
            return player;
        }
        return 0;
    }

    private boolean ok(int player) {
        switch (player) {
            case 1:
                for (int k : horizontal1) {
                    if (k == horizontal1.length) {
                        return true;
                    }
                }
                for (int k : vertial1) {
                    if (k == vertial1.length) {
                        return true;
                    }
                }
                int cnt = 0;
                for (int i = 0; i < horizontal1.length; i++) {
                    if (matrix[i][i] == 'X') {
                        cnt++;
                    }
                }
                if (cnt == n) {
                    return true;
                }
                cnt = 0;
                for (int i = 0; i < horizontal1.length; i++) {
                    if (matrix[i][horizontal1.length - 1 - i] != 'X') {
                        cnt = 1;
                        break;
                    }
                }
                return cnt == 0;
            case 2:
                for (int k : horizontal2) {
                    if (k == horizontal2.length) {
                        return true;
                    }
                }
                for (int k : vertial2) {
                    if (k == vertial2.length) {
                        return true;
                    }
                }
                cnt = 0;
                for (int i = 0; i < horizontal2.length; i++) {
                    if (matrix[i][i] != 'O') {
                        cnt = 1;
                        break;
                    }
                }
                if (cnt == 0) {
                    return true;
                }
                cnt = 0;
                for (int i = 0; i < horizontal2.length; i++) {
                    if (matrix[i][horizontal2.length - 1 - i] != 'O') {
                        cnt = 1;
                        break;
                    }
                }
                return cnt == 0;
        }
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
