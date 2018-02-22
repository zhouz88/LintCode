class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return 0;
        }
        char[] t = s.toCharArray();
        
        int len = s.length();
        int[] dp = new int[len];
        int i;
        int max = 0;
        dp[0] = 0;

        for (i = 1; i < t.length; i++) {
            if (t[i] == '(') {
                dp[i] = 0;
            } else {
                int m = dp[i - 1];
                if (i - 1 - m >= 0) {
                    dp[i] = (t[i - 1 - m] == '(' ? dp[i - 1] + 2 + (i - 2 - m >= 0 ? dp[i - 2 - m] : 0) : 0);
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
        }
        return max;
    }
}
