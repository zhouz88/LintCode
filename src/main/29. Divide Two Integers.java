class Solution {
    public int divide(int dividend, int divisor) {
        long sign = getSign(dividend, divisor);
        long D = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long res = Divider(D, d);
        if (sign*res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign*res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE; //WRONG 2
        }
        return (int)(sign*res);
    }

    private long Divider(long D, long d) {
        if (D < d) {
            return 0;
        }
        if (D == d) {
            return 1;
        }
        long cnt = 1;
        long tmp = d;
        while (d + d <= D) {
            cnt = cnt + cnt;
            d = d + d;
        }
        return cnt + Divider(D - d, tmp);//care tmp
    }

    private long getSign(int D, int d) {
        int cnt = 0;
        if (D < 0) {
            cnt++;
        }
        if (d < 0) {
            cnt++;
        }
        return cnt == 1 ? -1L : 1L;
    }
}
