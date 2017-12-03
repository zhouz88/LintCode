public class Solution {
    /*
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     89. k Sum 

 Description
 Notes
 Testcase
 Judge
Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Have you met this question in a real interview? Yes
Example
Given [1,2,3,4], k = 2, target = 5.

There are 2 solutions: [1,4] and [2,3].

Return 2.


     * @return: An integer
     */
    public int kSum(int[] A, int t, int target) {
        // write your code here
        int n = A.length;
        if (t > n || target < 0) {
            return 0;
        }
        int[][][] dp = new int[n + 1][t + 1][target + 1];
        if (A[0] <= target) {
            dp[1][1][A[0]] = 1;
        }
        dp[1][0][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= Math.min(t, i); j++) {
                for (int k = 0; k <= target; k++) {
                     if (i - 1 >= j) {
                         dp[i][j][k] = dp[i - 1][j][k];
                     }
                     if (k >= A[i -1] && k - A[i - 1] <= target && j >= 1 && dp[i - 1][j - 1][k - A[i - 1]] != 0) {
                          dp[i][j][k] += dp[i - 1][j - 1][k - A[i - 1]];
                     }
                }
            }
        }
        return dp[n][t][target];
    }
}
