class Solution {
    public int numSquares(int n) {
        if (n <= 3) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0; // care is zero not 1

        for (int i = 1; i <= n; i++) {
            int cur = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                if (i - j*j >= 0) {
                    cur = Math.min(dp[i - j*j] + 1, cur);
                }
            }
            dp[i] = cur;
        }

        return dp[n];
    }
}
