import java.util.*;

class Solution {
    public void solveSudoku(char[][] board) {
        Set<Integer>[] col = new HashSet[9];
        Set<Integer>[] row = new HashSet[9];
        Set<Integer>[][] cubic = new HashSet[3][3];
        int i, j;

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {

                if (col[j] == null) {
                    col[j] = new HashSet<>();
                }
                if (row[i] == null) {
                    row[i] = new HashSet<>();
                }
                if (cubic[i/3][j/3] == null) {
                    cubic[i/3][j/3] = new HashSet<>();
                }
                
                if (board[i][j] == '.') continue;
                
                col[j].add(board[i][j] - '0');
                row[i].add(board[i][j] - '0');
                cubic[i/3][j/3].add(board[i][j] - '0');
            }
        }

        update(board, col, row, cubic);
    }
    
    private boolean update(char[][] board, Set<Integer>[] col, Set<Integer>[] row, Set<Integer>[][] cubic) {
        boolean flag = false;
        int i, j;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int target = 1; target <= 9; target++) {
                        if (!row[i].contains(target) && !col[j].contains(target) && !cubic[i/3][j/3].contains(target)) {
                            board[i][j] = (char)(target + '0');
                            row[i].add(target);
                            col[j].add(target);
                            cubic[i/3][j/3].add(target);
                            
                            if (update(board, col, row, cubic)) {
                                return true;
                            } else {
                                 board[i][j] = '.';
                                row[i].remove(target);
                                col[j].remove(target);
                                cubic[i/3][j/3].remove(target);
                            }
                        }
                    }
                    return false;//如果 没有一个能够更改 就是错的；说明改错了
                }
            }
        }
        return true;
    }
}
