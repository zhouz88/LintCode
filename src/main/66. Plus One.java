import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] < 10) {
                break;
            } else {
                digits[i] = 0;
            }
        }
        
        int[] ret = new int[digits.length];
        
        if (Arrays.equals(ret, digits)) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        
        return digits;
    }
}
