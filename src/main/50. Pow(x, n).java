class Solution {
    public double myPow(double x, int n) {
        double sign = n < 0 ? -1 : 1;
        long N = Math.abs((long)n);
        double ans = 1.0, tmp = x;
        
        while (N != 0) {
            if (N % 2 == 1) {
                ans *= tmp;
            }
            tmp *= tmp;
            N/= 2;
        }
        
        return sign == -1 ? 1/ans : ans;
    }
}
