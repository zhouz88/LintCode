class Solution {
    public double myPow(double x, int N) { 
        long n = (long)N;//第一步 考虑越界！！！！！！！！！！
        if (n == 0) {
            return 1;
        }
        
        long len = 1;
        double res = 1.0;
        double pre = x;
        int sign = 1;
        if (n < 0) {
            n = -n;
            sign = -1;
        }
        while (n > 0) {
            x *= x;
            len *= 2;
            long m = n % len;
            n -= m;
            if (m != 0) {
                res *= pre;
            }
            pre = x;
        }

        return sign == 1 ?res : 1.0/res;
    }
}
