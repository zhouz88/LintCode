public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
   public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}



public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
   public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int[] ret = new int[3];
        ret[0] = 1;
        ret[1] = 1;
        for (int i = 2; i <= n; i++) {
            ret[2] = ret[1] + ret[0];
            ret[0] = ret[1];
            ret[1] = ret[2];
        }
        return ret[2];
    }
}
