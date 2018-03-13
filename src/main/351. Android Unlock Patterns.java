class Solution {
    private int res = 0;

    public int numberOfPatterns(int m, int n) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[][] visited = new boolean[3][3];
                visited[i][j] = true;
                dfs(i, j, visited, m, n, 1);
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] visited, int m, int n, int count) {
        if (count >= m && count < n) {
            res ++;
        }
        if (count == n) {
            res++;
            return;
        }
        for (int[] dir : DIRECTIONS) {
            int deltax = dir[0];
            int deltay = dir[1];
            int x = deltax + i;
            int y = deltay + j;
            if (x>=0&&y>=0&&x<3&&y<3) {
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    dfs(x, y, visited, m, n, count + 1);
                    visited[x][y] = false;
                    continue;
                }
                if (x + deltax < 3 && y + deltay < 3 && x + deltax  >= 0 && y + deltay >= 0 && !visited[x + deltax][y + deltay]) {
                    x += deltax;
                    y += deltay;
                    visited[x][y] = true;
                    dfs(x, y, visited, m, n, count + 1);
                    visited[x][y] = false;
                }
            }
        }
    }

    private static final int[][] DIRECTIONS = {{1, 0},{-1, 0},{0, 1},{0, -1},{1, 1},{-1, 1},{1, -1},{-1, -1},
            {1, 2},{-1, 2},{2, 1},{2, -1},
            {1, -2},{-1, -2},{-2, 1},{-2, -1}};

}
