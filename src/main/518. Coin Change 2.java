import java.util.Arrays;

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}
//与target sum 01 pack 问题区别
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
       int sum = 0;
       for (int k : nums) {
           sum += k;
       }
       if (sum < S) return 0;
       S += sum;
       for (int i = 0; i < nums.length; i++) {
           nums[i] *= 2;
       }
       int len = nums.length;
       int[][] dp = new int[len + 1][S + 1];
       //dp[i][j] i means the less than (i - 1) nums, j stands for sum;
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= S; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] : 0);
            }
        }
        return dp[len][S];
    }
}
