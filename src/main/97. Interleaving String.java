class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //egge case
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int i, j;
        int m = s1.length();
        int n = s2.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (i = 0; i < m; i++) {
            if (s3.charAt(i) == s1.charAt(i)) {
                dp[i + 1][0] = true;
            } else {
                break;
            }
        }
        
        for (i = 0; i < n; i++) {
            if (s3.charAt(i) == s2.charAt(i)) {
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }
        
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (s1.charAt(i) == s3.charAt(i + j + 1)) {
                    dp[i + 1][j + 1] |= dp[i][j + 1];
                }
                if (s2.charAt(j) == s3.charAt(i + j + 1)) {
                    dp[i + 1][j + 1] |= dp[i + 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}
