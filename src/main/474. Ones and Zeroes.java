class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] store = new int[strs.length][2];

        for (int i = 0; i < strs.length; i++) {
            int cnt = 0;
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') {
                    cnt++;
                }
            }
            store[i][0] = cnt;
            store[i][1] = strs[i].length() - cnt;
        }

        int[][][] dp = new int[l + 1][m + 1][n + 1];

        for (int i = 1; i <= l; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= store[i - 1][0] && k >= store[i - 1][1]) {
                        dp[i][j][k] = Math.max(1 + dp[i - 1][j - store[i - 1][0]][k - store[i - 1][1]], dp[i - 1][j][k]);
                    }
                }
            }
        }

        return dp[l][m][n];
    }
}
