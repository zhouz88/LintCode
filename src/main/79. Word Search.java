class Solution {
    
    //https://stackoverflow.com/questions/1294720/whats-the-difference-between-backtracking-and-depth-first-search
    public boolean exist(char[][] board, String word) {
        //corner case
         if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
             return false;
         }
         if (word.equals("")) {
             return true;
         }
         for (int i = 0; i < board.length; i++) {
             for (int j = 0; j < board[0].length; j++) {
                 if (dfs(board, word, i, j, 0)) {
                     return true;
                 }
             }
         }
         return false;
    }
    
    private final static int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private boolean dfs(char[][] board, String word, int i, int j, int start) {
        if (start == word.length()) {
            return true;
        }
        if (board[i][j] != word.charAt(start)) {
            return false;
        }
        if (start == word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '*';
        boolean found = false;
        for (int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x<0||y<0||x>=board.length||y>=board[0].length||board[x][y]=='*') continue;
            found = found || dfs(board, word, x, y, start + 1);
        }
        board[i][j] = tmp;
        return found;
    }
}
