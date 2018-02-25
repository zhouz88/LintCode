class Solution {
    public int numWays(int n, int k) {
        // dp[n] = (k - 1) * n - 2, n - 1;
        // dp红[n] = (k  - 1)* dp非红[n - 1] + (K - 1) * dp非红[n - 2];
        
        if (n == 0 || k == 0) { //bug twice 
            return 0;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        if (n == 1) {
            return k;
        }
        
        dp[2] = k;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * dp[i - 1] + (k - 1) * dp[i - 2];
        }
        
        return k * dp[n];
    }
}
