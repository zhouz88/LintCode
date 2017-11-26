public class Solution {
    /*
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    TrieNode root = new TrieNode();
    
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }
        for (String k : words) {
            insert(k);
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(root, board,res,m,n,i,j);
            }
        }
        return res;
    }
    
    private final static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    void find(TrieNode root, char[][] board, List<String> res, int m, int n,int i, int j) {
        if (root == null) {
            return;
        }
        if (root.isWord) {
            res.add(root.s);
            root.isWord = false;
        }
        root = root.map[board[i][j] - 'a'];
        if (root == null) return;
        if (root.isWord) {
            res.add(root.s);
            root.isWord = false;
        }
        char tmp = board[i][j];
        board[i][j] = '*';
        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x<0||y<0||x>=m||y>=n||board[x][y]=='*') continue;
            find(root, board, res, m,n,x,y);
        }
        board[i][j] = tmp;
    }
    
    class TrieNode {
        TrieNode[] map = new TrieNode[26];
        boolean isWord = false;
        String s = null;
    }
     
    void insert(String word) {
        TrieNode tmp = root;
        for (char ch : word.toCharArray()) {
            if (tmp.map[ch - 'a'] == null) {
                tmp.map[ch - 'a'] = new TrieNode();
            }
            tmp = tmp.map[ch - 'a'];
        }
        tmp.isWord = true;
        tmp.s = word;
    }
}
