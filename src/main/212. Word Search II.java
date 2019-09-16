import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int[][] DIRECTIONS = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length, n = board[0].length;
        
        //check empty string;
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.nodes[board[i][j] - 'a'] != null) {
                    char temp = board[i][j];
                    if (root.nodes[board[i][j] - 'a'].word != null) {
                        res.add(root.nodes[board[i][j] - 'a'].word);
                        root.nodes[board[i][j] - 'a'].word = null;
                    }
                    board[i][j] = '*';
                    dfs(i, j, root.nodes[temp - 'a'], board, m, n, res);
                    board[i][j] = temp;
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, TrieNode node, char[][] board, int m, int n, List<String> res) {
        for (int[] dir : DIRECTIONS) {
            int nx = dir[0] + i;
            int ny = dir[1] + j;
            if (nx>=0&&ny>=0&&nx<m&&ny<n&&board[nx][ny]!='*'
                    &&node.nodes[board[nx][ny] - 'a']!=null) {
                if (node.nodes[board[nx][ny] - 'a'].word != null) {
                    res.add(node.nodes[board[nx][ny] - 'a'].word);
                    node.nodes[board[nx][ny] - 'a'].word = null;
                }
                char temp = board[nx][ny];
                board[nx][ny] = '*';
                dfs(nx, ny, node.nodes[temp - 'a'], board, m, n, res);
                board[nx][ny] = temp;
            }
        }
    }


    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String k : words) {
            TrieNode node = root;
            for (char ch : k.toCharArray()) {
                if (node.nodes[ch - 'a'] == null) {
                    node.nodes[ch - 'a'] = new TrieNode();
                }
                node = node.nodes[ch - 'a'];
            }
            node.word = k;
        }
        return root;
    }

    private static final class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        String word = null;
    }
}
