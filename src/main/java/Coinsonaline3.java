public class Solution {
    /*
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     396. Coins in a Line III 

 Description
 Notes
 Testcase
 Judge
There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.

Could you please decide the first player will win or lose?
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = values[i - 1] + sum[i - 1];
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = values[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(values[i] + sum(i+1, j, sum) - dp[i + 1][j], sum(i, j- 1,sum)-dp[i][j - 1] + values[j]);
            }
        }
        return dp[0][n - 1] + dp[0][n - 1] >= sum(0, n - 1, sum);
    }
    
    public int sum(int start, int end, int[] sum) {
        return sum[end+1] - sum[start];
    }
}
