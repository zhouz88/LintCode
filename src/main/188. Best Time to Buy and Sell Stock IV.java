public class Solution {
    /*
     * @param K: An integer
     * @param prices: An integer array
     * @return: Maximum profit
     */
    public int maxProfit(int K, int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1 || K == 0) {
            return 0;
        }

        if (K >= prices.length/2) {
            return maxProfit(prices);
        }

        int N = prices.length;
        int[][] dp = new int[K][N];

        int k, n;
        for (k = 0; k < K; k++) {
            int ensWithmax = -prices[0];
            for (n = 1; n < N; n++) {
                dp[k][n] = Math.max(dp[k][n - 1], prices[n] + ensWithmax);
                ensWithmax = Math.max( (k >= 1 ? dp[k - 1][n - 1] : 0) - prices[n], ensWithmax);
            }
        }

        return dp[K - 1][N - 1];
    }

    private int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sum += prices[i + 1] - prices[i];
            }
        }
        return sum;
    }
}
