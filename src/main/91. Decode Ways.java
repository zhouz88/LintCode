class Solution {
    public int numDecodings(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
            if (i > 0) {
                int tmp = s.charAt(i) - '0' + (s.charAt(i - 1) - '0') * 10;
                if (tmp >= 10 && tmp <= 26) {
                    dp[i + 1] += dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }
}
