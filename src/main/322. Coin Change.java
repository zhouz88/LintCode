import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int cur = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    cur = Math.min(dp[i - coin] + 1, cur);
                } else if (i - coin < 0) {
                    break;
                }
            }
            dp[i] = cur;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
