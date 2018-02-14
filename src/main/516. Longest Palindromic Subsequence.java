516. Longest Palindromic Subsequenceclass 
Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[][] dp = new int[n][n];
        int i, j;

        for (i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        int ans = 1;
        for (i = n - 2; i >= 0; i--) {
            for (j = i + 1; j < n; j++) {
                if (j - i > 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) ? 2 : 1);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}
