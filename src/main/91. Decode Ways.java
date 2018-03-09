class Solution {
    public int numDecodings(String s) {
        int m = s.length();
        if (m == 0) {
            return 0;
        }
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != '0') {
                dp[2] += dp[1];
            }
            if (i >= 1) {
                int tmp = 10 * (s.charAt(i - 1) - '0') + s.charAt(i) - '0';
                if (tmp <= 26 && tmp >= 10) {
                    dp[2]  += dp[0];
                }
            }          
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = 0;
        }
        return dp[1];
    }
}
