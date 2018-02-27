class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = 0;
            for (int j = 1; j < i; j++) {
                int a = Math.max(dp[j], j);
                int b = Math.max(dp[i - j], i - j);
                tmp = Math.max(tmp,  a*b);
            }
            dp[i] = tmp;
        }
        return dp[n];
    }
}
