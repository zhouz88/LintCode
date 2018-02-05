public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, long n) {
        // Write your code here
         if (n < 0) {
             n = -n;
             x = 1.0/x;
         }
         
         double ans = 1.0, tmp = x;
         
         while (n != 0) {
             if (n%2 == 1) {
                 ans *= tmp;
             }
             tmp *= tmp;
             n /= 2;
        }
        
        return ans;
    }
}
