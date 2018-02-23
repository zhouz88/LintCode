class Solution {
    /*
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1.length() != s2.length()) {
            return false;
        }
        int m = s1.length();
        
        boolean[][][] dp = new boolean[m][m][m + 1];
        
        int i, j, len;
        for (i = 0; i < m; i++) 
            for (j = 0; j < m; j++) 
                if (s1.charAt(i) == s2.charAt(j)) dp[i][j][1] = true;
            
        for (len = 2; len <= m; len++) {
            for(i = 0; i <= m - len; i++) {
                for (j = 0; j <= m - len; j++) {
                    for (int k = 1; k < len; k++) {
                        dp[i][j][len] |= (dp[i + k][j + k][len - k] && dp[i][j][k]);
                        dp[i][j][len] |= (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
                        if (dp[i][j][len]) {
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][m];
    }
}
