class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};

    private boolean dfs(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) {//if word == ""
            return true;
        }
        if (word.charAt(start) != board[i][j]) {
            return false;
        }
        if (start == word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '*';
        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x>=0&&y>=0&&x<board.length&&y<board[0].length&&board[x][y]!='*') {
                if (dfs(board, x, y, word, start + 1)) {
                    return true;
                }
            }
        }
        board[i][j] = tmp;
        return false;
    }
}
