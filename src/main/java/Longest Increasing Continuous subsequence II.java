public class Solution {
    /*
     * @param A: An integer matrix
     * @return: an integer
     
     398. Longest Increasing Continuous subsequence II 

 Description
 Notes
 Testcase
 Judge
Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // write your code here
        if (A == null) {
            return 0;
        }
        int m = A.length;
        if (m == 0) {
            return 0;
        }
        int n = A[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, A, dp,m,n));
            }
        }
        return max;
    }
    
    private final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int dfs(int i , int j, int[][] A, int[][] dp, int m, int n) {
        int max = 1;
        for (int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x <0||y<0||x>=m||y>=n||A[x][y]<=A[i][j]) {
                continue;
            }
            if (dp[x][y] != -1) {
                max = Math.max(max, dp[x][y] + 1);
            } else {
                max = Math.max(max, dfs(x, y, A, dp, m, n) + 1);
            }
        }
        dp[i][j] = max;
        return max;
    }
}
