public class Solution {
    /*
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here
       if (x == 0 || x == 1.0) {
           return x;
       }
       double l = 0;
       double r = x;
       if (x < 1.0) {
           r = 1;
       }
       while (r - l >= 1e-12) {
           double mid = (l + r)/2;
           if (mid*mid > x) {
               r = mid;
           } else {
               l = mid;
           }
       }
       return r;
    }
}
