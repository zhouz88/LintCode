]class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        int i, j ;
        for (j = 0; j + 1 < p.length(); j += 2) {
            if (p.charAt(j) != '*' && p.charAt(j + 1) == '*') {
                dp[0][j + 2] = true;
            } else {
                break;
            }
        }

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (p.charAt(j) == '*') {
                    if (j >= 1 && p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i][j + 1];
                    } else if (j >= 1){
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                } else {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
