class Solution {
    public int numDecodings(String s) {
        int m = s.length();
        if (m == 0) {
            return 0;
        }
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != '0') {
                dp[2] += dp[1];
            }
            if (i >= 1) {
                int tmp = 10 * (s.charAt(i - 1) - '0') + s.charAt(i) - '0';
                if (tmp <= 26 && tmp >= 10) {
                    dp[2]  += dp[0];
                }
            }          
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = 0;
        }
        return dp[1];
    }
}

//*
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[1 + s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                int tmp = 10 * (s.charAt(i - 2) - '0') + s.charAt(i - 1) - '0';
                if (tmp >= 10 && tmp <= 26) {
                    dp[i] += dp[i - 2]; 
                }
            }
        }
        return dp[s.length()];
    }
}

//*
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        long[] dp = new long[1 + s.length()];
        dp[0] = 1L;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) == '*') {
                dp[i] += 9 * dp[i - 1];
            } else {
                if (s.charAt(i - 1) != '0') {
                    dp[i] += dp[i - 1];
                }
            }
            //two;
            if (i > 1) {
                if (s.charAt(i - 1) == '*') {
                    if (s.charAt(i - 2) == '*') {
                        dp[i] += 15 * dp[i - 2];
                    } else if (s.charAt(i - 2) == '0'){
                        continue;
                    } else {
                        int count = 0;
                        int tmp = s.charAt(i - 2) - '0';
                        for (int j = 1; j <= 9; j++) {
                            if (tmp * 10 + j >= 10 && tmp * 10 + j <= 26) {
                                count++;
                            }
                        }
                        dp[i] += count * dp[i - 2];
                    }
                } else {//number
                    if (s.charAt(i - 2) == '*') {
                        for (int j = 1; j <= 9; j++) {
                            int tmp = 10 * j + s.charAt(i - 1) - '0';
                            if (tmp >= 10 && tmp <= 26) {
                                dp[i] += dp[i - 2];
                            }
                        }
                    } else {
                        int tmp = 10 * (s.charAt(i - 2) - '0') + s.charAt(i - 1) - '0';
                        if (tmp >= 10 && tmp <= 26) {
                            dp[i] += dp[i - 2];
                        }
                    }
                }
            }
            dp[i] %= 1000000007L;
        }
        return (int) dp[s.length()];
    }
}
