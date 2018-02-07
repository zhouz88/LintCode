import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0|| board[0].length == 0) {
            return;
        }
        int i, j;
        m = board.length;
        n = board[0].length;

        for (i = 0; i < m; i++) {
            if (board[i][0] == 'O') bfs(board, i, 0, 'O', 'S');
            if (board[i][n - 1] == 'O') bfs(board, i, n-1, 'O', 'S');
        }

        for (j = 0; j < n; j++) {
            if (board[0][j] == 'O') bfs(board, 0, j, 'O', 'S');
            if (board[m - 1][j] == 'O') bfs(board, m - 1, j, 'O', 'S');
        }

        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++)
                if (board[i][j] == 'O')
                    bfs(board, i, j, 'O', 'X');


        for (i = 0; i < m; i++) {
            if (board[i][0] == 'S') bfs(board, i, 0,  'S', 'O');
            if (board[i][n - 1] == 'S') bfs(board, i, n-1,'S', 'O');//wrong 1 no bfs3
        }

        for (j = 0; j < n; j++) {
            if (board[0][j] == 'S') bfs(board, 0, j,'S', 'O');
            if (board[m - 1][j] == 'S') bfs(board, m - 1, j, 'S', 'O');
        }
    }

    private static final int[][] DIRECTIONS = {{0 ,1},{0, -1},{1, 0},{-1, 0}};
    private static int m;
    private static int n;

    private void bfs(char[][] board, int i, int j, char from, char to) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        board[i][j] = to;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : DIRECTIONS) {
                int x = dir[0] + node[0];
                int y = dir[1] + node[1];
                if (x<=0||y<=0||x>=m||y>=n||board[x][y]!=from) {
                    continue;
                }
                board[x][y] = to;
                q.add(new int[]{x, y});
            }
        }
    }
}
