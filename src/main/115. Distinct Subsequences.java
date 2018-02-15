class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        
        if (m == 0 ||  n == 0) {
            return 0;
        }
        
        int[][] dp = new int[m][n];
        
        int i, j;
        
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (i = 1; i < m; i++) {
           dp[i][0] = (s.charAt(i) == t.charAt(0) ? 1 : 0) + dp[i - 1][0];
        }
        
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                } 
            }
        }
        
        return dp[m - 1][n - 1];
    }
}


class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i<= m;i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = ((S.charAt(i - 1) == T.charAt(j - 1) ?dp[i - 1][j - 1] : 0)) + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}
