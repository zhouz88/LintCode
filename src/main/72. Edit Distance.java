class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        
        //initial condition
        for (int j = 1; j <= n ; j++) {
            dp[0][j] = j; //wrong 1 should be j not 1
        }
        for (int j = 1; j <= m ; j++) {
            dp[j][0] = j;
        }
        
        //
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int a = dp[i + 1][j] + 1;
                    int b = dp[i][j + 1] + 1;
                    int c = dp[i][j] + 1;
                    dp[i + 1][j + 1] = Math.min(Math.min(a, b), c);
                }
            }
        }
        
        return dp[m][n];
    }
}
