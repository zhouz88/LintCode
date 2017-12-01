public class Solution {
    /*
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     436. Maximal Square 

 Description
 Notes
 Testcase
 Judge
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

Have you met this question in a real interview? Yes
Example
For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
     */
    public int maxSquare(int[][] M) {
        // write your code here
        if (M == null) {
            return 0;
        }
        
        int m = M.length;
        int n = M[0].length;
        if (m == 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        
        int[][] dp = new int[m][n];
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            if (M[i][0] == 1) {
                dp[i][0] = 1;
                max = Math.max(max, dp[i][0]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (M[0][i] == 1) {
                dp[0][i] = 1;
                max = Math.max(max, dp[0][i]);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (M[i][j] != 1) continue;
                dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
