import java.util.Arrays;

class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length==0||M[0].length ==0) {
            return 0;
        }
        int m = M.length, n = M[0].length;
        final int[][] directions = {{0, 1},{1, 1},{1, 0},{1, -1}};
        int[][][] dp = new int[4][m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    int k = 0;
                    for (int[] dir : directions) {
                        max = Math.max(max, check(M, i, j, dir, dp[k++]));
                    }
                }
            }
        }
        return max;
    }

    private int check(int[][] M, int i, int j, int[] dir, int[][] dp) {
        if (i>=0&&i<M.length&&j>=0&&j<M[0].length&&M[i][j]==1) {
            if(dp[i][j]!=0) return dp[i][j];
            else return dp[i][j] = 1 + check(M, i + dir[0], j + dir[1], dir, dp);
        } else {
            return 0;
        }
    }
}
