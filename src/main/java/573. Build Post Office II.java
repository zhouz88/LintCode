import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;
        int[][][] map = new int[m*n][][];
        List<Integer> list = new ArrayList<>();

        int i, j;
        
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    list.add(i*n+j);
                }
            }
        }

        for (int node : list) {
            int[][] dp = new int[m][n];
            map[node] = dp;
            
            for (i = 0; i < m; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            
            dp[node/n][node%n] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);
            
            while (!queue.isEmpty()) {
                int tmp = queue.poll();
                for (int[] dir : DIRECTIONS) {
                    int x = dir[0] + tmp/n;
                    int y = dir[1] + tmp%n;
                    if (x<0||y<0||x>=m||y>=n||grid[x][y]==2||grid[x][y]==1||dp[x][y]!=Integer.MAX_VALUE){
                        continue;
                    }
                    dp[x][y] = dp[tmp/n][tmp%n] + 1;
                    queue.add(x*n+y);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                   int total = 0;
                   for (int k : list) {
                       if (map[k][i][j] != Integer.MAX_VALUE) {
                           total += map[k][i][j];
                       } else {
                           total = Integer.MAX_VALUE;
                           break;
                       }
                   }
                   min = Math.min(min, total);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
}
