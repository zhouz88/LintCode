class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int len = (n + "").length();
        long[] dp = new long[15];
        dp[1] = 1L;

        for (int i = 2; i <= 14; i++) {
            dp[i] = 10*dp[i - 1] + (int)Math.pow(10, i - 1);
            // System.out.println(totalOnesOflenth[i - 1]);
        }

        char[] t = (""+n).toCharArray();
        int cnt = 0;
        int preones = 0;
        for (int i = 0; i < t.length; i++) {
            int cur = t[i] - '0';
            int length = len - i - 1;

            if (cur == 0) {
                cnt += preones * cur * (int)Math.pow(10, length);
                continue;
            } else if (cur == 1) {
                int tmp = cur * (int)dp[length] + 1;
                cnt += tmp + preones * (int)Math.pow(10, length);
                preones++;
            } else {
                int tmp = (cur) * (int)dp[length] + (int) Math.pow(10, length);
                cnt += tmp + preones * cur * (int)Math.pow(10, length);
            }

        }

        return cnt;
    }
}
