public class Solution {
    /*
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board==null||board.length==0||board[0].length==0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                if(dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public boolean dfs(int i, int j, char[][] board, String word, int start) {
        if (start == word.length()) {
            return true;
        }
        int m = board.length,  n = board[0].length;
        boolean found = false;
        char tmp = board[i][j];
        if (board[i][j] != word.charAt(start)) {
            return found;
        } else {
            board[i][j] = '*';
        }
        if (start == word.length() - 1) {
            return true;
        }
        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x<0||y<0||x>=m||y>=n) {
                continue;
            }
            found = found||dfs(x,y,board,word,start+1);
        }
        board[i][j] = tmp;
        return found;
    }
}
