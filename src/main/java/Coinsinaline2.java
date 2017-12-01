public class Solution {
    /*
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     395. Coins in a Line II 

 Description
 Notes
 Testcase
 Judge
There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Have you met this question in a real interview? Yes
Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false.


     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        if (n <= 2) {
            return true;
        }
        int[] dp = new int[n];
        int[] sum   = new int[n];
        sum[n - 1] = values[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + values[i];
        } 
        dp[n - 1] = values[n - 1];
        dp[n - 2] = values[n - 1] + values[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(sum[i] - dp[i+2], sum[i] - dp[i+1]);
        }
        return dp[0] + dp[0] > sum[0];
    }
}
