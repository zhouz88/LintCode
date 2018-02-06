import java.util.Arrays;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] ret = new int[3];
        Arrays.fill(ret, Integer.MAX_VALUE);
        
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= ret[0]) {
                ret[0] = nums[i];
            } else if (nums[i] <= ret[1]) {
                ret[1] = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
