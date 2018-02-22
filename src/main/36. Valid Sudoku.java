class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] check;
        int i, j;
        for (i = 0;i < 9; i++) {
            check = new boolean[256];
            for (j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (check[board[i][j]]) return false;
                    check[board[i][j]] = true;
                }
            }
        }

        for (j = 0; j < 9; j++) {
            check = new boolean[256];
            for (i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (check[board[i][j]]) return false;
                    check[board[i][j]] = true;
                }
            }
        }

        for (i = 0; i <= 6; i += 3) {
            for (j = 0; j <= 6; j += 3) {
                check = new boolean[256];
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (board[x][y] != '.') {
                            if (check[board[x][y]]) return false;
                            check[board[x][y]] = true;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
