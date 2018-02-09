public class Solution {
    /*
     * @param n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if (n <= 0) {
            return 1;
        }
        
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int i, j;
        for (i = 3; i <= n; i++) {
            for (j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i - 1 - j];
            }
        }
        
        return dp[n];
    }
}
