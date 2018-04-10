class Solution {
    public String encode(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = s.charAt(i) +"";
        }
        for (int len = 2; len <= n; len ++ ) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                //dp[i][j]
                for (int k = i; k < j; k++) {
                    String tmp = dp[i][k] + dp[k + 1][j];
                    if (dp[i][j] == null || tmp.length() < dp[i][j].length()) {
                        dp[i][j] = tmp;
                    }
                }
                //check i ----j;abcabc
                String t = s.substring(i, j + 1);
                String o = t + t;
                if (o.substring(1, o.length() - 1).contains(t)) {
                    int idx = o.indexOf(t, 1);
                    int total = t.length()/idx;
                    String cur = total + "[" + dp[i][i + idx - 1] + "]";
                    if (dp[i][j].length() > cur.length()) {
                        dp[i][j] = cur;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
