import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[m*n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        int i, j;
        int ans = 1;
        
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                ans = Math.max(dfs(dp, matrix, i, j, m, n), ans);
            }
        }
        
        return ans;
    }
    private static final int[][] DIRECTIONS = {{1, 0},{0, 1},{-1, 0},{0 ,- 1}};
    
    private int dfs(int[] dp, int[][] matrix, int i, int j, int  m,  int n) {
        //cornercase
        if (dp[i*n + j] != Integer.MAX_VALUE) {
            return dp[i*n + j];
        }
        
        int ret = 1;
        
        for (int[] dir : DIRECTIONS) {
            int x= dir[0]  + i;
            int y = dir[1] + j;
            if (x<0||y<0||x>=m||y>=n||matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            ret = Math.max(ret, 1 + dfs(dp, matrix, x, y, m, n));
         }

         dp[i*n + j] = ret;         
         return ret;
        
    }
}

