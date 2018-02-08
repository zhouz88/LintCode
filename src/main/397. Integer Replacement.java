import java.util.Arrays;

class Solution {
    public long integerReplacement(long n) {
        if (n == 1) {
            return 0;
        }
        if ((n & 1) == 1) {
            return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
        } else {
            return 1 + integerReplacement(n/2);
        }
    }
    
     public int integerReplacement(int n) {
        return (int) integerReplacement((long)n);
    }
}
