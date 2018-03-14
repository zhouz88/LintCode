class Solution {
    public int getMoneyAmount(int n) {
        this.dp = new int[n + 1][n + 1];
        return helper(1, n);
    }
    
    int[][] dp;
    
    private int helper(int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            res = Math.min(res, i + Math.max(helper(start, i - 1), helper(i + 1, end)));
        }
        dp[start][end] = res;
        return res;
    }
}

//
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = 999999999;
                for (int x = i; x < j; x ++) {
                    min = Math.min(x + Math.max(dp[i][x - 1], dp[x + 1][j]), min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}
