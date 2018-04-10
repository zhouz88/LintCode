import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length  == 0) {
            return res;
        }
        TrieNode root = new TrieNode();
        buildTrie(words, root);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, board, root, i, j);
            }
        }
        return res;
    }

    private static int[][] DIRECTIONS = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    private void dfs(List<String> res, char[][] board, TrieNode root, int i, int j) {
        // if (root.word != null) { // to avoid "" in the dic
        //     res.add(root.word);
        //     root.word = null;
        // }
        if (root.map[board[i][j] - 'a'] == null) {
            return;
        }
        if (root.map[board[i][j] - 'a'].word != null) {
            res.add(root.map[board[i][j] - 'a'].word);
            root.map[board[i][j] - 'a'].word = null;
        }
        char tmp = board[i][j];
        board[i][j] = '*';
        for (int[] dir :DIRECTIONS) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x>=0&&y>=0&&x<board.length&&y<board[0].length&&board[x][y]!='*') {
                dfs(res, board, root.map[tmp - 'a'], x, y);
            }
        }
        board[i][j] = tmp;
    }

    private void buildTrie(String[] words, TrieNode root) {
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char ch : words[i].toCharArray()) {
                if (node.map[ch - 'a'] == null) {
                    node.map[ch - 'a'] = new TrieNode();
                }
                node = node.map[ch - 'a'];
            }
            node.word = words[i];
        }
    }

    private static class TrieNode{
        TrieNode[] map;
        String word;
        public TrieNode(){
            this.map = new TrieNode[26];
            word = null;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[1][2];
        board[0][0] = 'a';
        board[0][1] = 'b';
        String[] words = {"ab"};
        System.out.println(new Solution().findWords(board, words));
    }
}
