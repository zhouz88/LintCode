class Solution {
    public int[] singleNumber(int[] nums) {
        int num = 0;
        for (int k : nums) {
            num ^= k;
        }
        
        int target = (num & (num - 1)) ^ num;
        
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & target) == target) {
                ret[0] ^= nums[i];
            } else {
                ret[1] ^= nums[i];
            }
        }
        return ret;
    }
}
