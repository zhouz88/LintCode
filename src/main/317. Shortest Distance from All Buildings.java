import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int i, j;
        int cnt = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        int[] counts = new int[m * n];
        int p = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(counts, distance, i, j, grid, p);
                    p++;
                }
            }
        }
        int min = (1 << 31) - 1;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (counts[i *n + j] == cnt) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }
        return min == (1 << 31) - 1 ? -1 : min;
    }

    private static int[][] DIRECTIONS = {{1,0},{0,1},{0,-1},{-1,0}};

    private void bfs(int[] counts, int[][] distance, int i, int j, int[][] grid, int p) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        visited[i][j]= true;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int z = 0; z < size; z ++) {
                int[] node = q.poll();
                for (int[] dir : DIRECTIONS) {
                    int x = dir[0] + node[0];
                    int y = dir[1] + node[1];
                    if (x>=0&&y>=0&&x<m&&y<n&&!visited[x][y]&&grid[x][y]==0 && counts[x*n+y]==p) {
                        q.add(new int[]{x,y});
                        distance[x][y] += step;
                        counts[x * n + y]++;
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
