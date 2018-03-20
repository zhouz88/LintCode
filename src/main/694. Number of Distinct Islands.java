import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (grid[i][j] == 1) {
                    String t =  bfs(i,j, grid);
                    set.add(t);
                }
            }
        }
        return set.size();
    }

    private static int[][] DIRECTIONS = {{1, 0},{-1, 0},{0, -1},{0, 1}};

    private String bfs(int i, int j, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(new int[]{i, j});
        grid[i][j] = 0;
        String start = "(" + 0 + " "+  0 + ")";
        sb.append(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                int[] node = q.poll();
                for (int k = 0; k < DIRECTIONS.length; k++) {
                    int[] dir = DIRECTIONS[k];
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    if (x>=0&&y>=0&&x<grid.length&&y<grid[0].length&&grid[x][y]==1) {
                        grid[x][y] = 0;
                        q.add(new int[]{x, y});
                        sb.append("(" + (x - i) + " "+  (y - j) + ")");
                    }
                }
            }
        }
        return sb.toString();
    }
}
