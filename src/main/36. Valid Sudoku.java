class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] col = new boolean[128];
            boolean[] row = new boolean[128];
            boolean[] cubic = new boolean[128];
            int starti = 3 * (i/3);
            int startj = 3 * (i%3);
            for (int j =  0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j]]) return false;
                    else row[board[i][j]] = true;
                }
                
                if (board[j][i] != '.') {
                    if (col[board[j][i]]) return false;
                    else col[board[j][i]] = true;
                }
                
                int I = j/3 + starti;
                int J = j%3 + startj;
                
                if (board[I][J] != '.') {
                    if (cubic[board[I][J]]) return false;
                    else cubic[board[I][J]] = true;
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
