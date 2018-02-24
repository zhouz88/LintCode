import java.util.ArrayList;
import java.util.List;

class Solution {

    private T root;

    public List<String> findWords(char[][] board, String[] words) {
        //edge case
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        this.root = new T();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        int i, j;
        List<String> ret = new ArrayList<>();

        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                update(board, i, j, root, ret);
            }
        }

        return ret;
    }

    private int[][] DIRECTIONS = {{1, 0},{-1, 0},{0, 1},{0, -1}};

    private void update(char[][] board, int i, int j, T root, List<String> ret) {
        //base to avoid "" in the original list
        if (root.isWord) {
            ret.add(root.word);
            root.isWord = false;
        }

        char ch = board[i][j];
        board[i][j] = '*';

        if (root.map[ch - 'a'] != null) {
            if (root.map[ch - 'a'].isWord) {
                ret.add(root.map[ch - 'a'].word);   //bug N次这种错误了
                root.map[ch - 'a'].isWord = false;
            }
            for (int[] dir : DIRECTIONS) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x>=0&&y>=0&&x<board.length&&y<board[0].length&&board[x][y]!='*') {
                    update(board,x , y, root.map[ch - 'a'], ret);
                }
            }
        }

        board[i][j] = ch;
    }

    class T {
        T[] map = new T[26];
        boolean isWord = false;
        String word = null;
    }

    private void insert(String word) {
        T node = root;
        for (char ch : word.toCharArray()) {
            if (node.map[ch - 'a'] == null) {
                node.map[ch - 'a'] = new T();
            }
            node = node.map[ch - 'a'];
        }
        node.isWord = true;
        node.word = word;
    }
}
