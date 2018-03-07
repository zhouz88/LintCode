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

//
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> cubicSet = new HashSet<>();
            int len = 3 * (i/3);
            int n = 3 * (i%3);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j] - '0')) {
                    return false;
                }
                if (board[j][i] != '.' && !colSet.add(board[j][i] - '0')) {
                    return false;
                }
                if (board[len + j/3][n + j%3] != '.' && !cubicSet.add(board[len + j/3][n + j%3] - '0')) {
                    return false;
                }
            }
        }
        return true;
    }
}
