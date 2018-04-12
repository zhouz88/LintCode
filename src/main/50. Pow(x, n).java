class Solution {
    public double myPow(double x, int n) {
        long N = Math.abs((long)n);
        double res = 1.0;
        while (N != 0) {
            if (N % 2 == 1) {
                res *= x;
            }
            x *= x;
            N/= 2;
        }
        return n < 0 ? 1/res: res;
    }
}
