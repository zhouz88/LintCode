class Solution {
    public int[] productExceptSelf(int[] nums) {

        //corner case
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int[] ret = new int[nums.length];
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int i = nums.length - 2; i >= 0;i--) {
            tmp *= nums[i + 1];
            ret[i] *= tmp;
        }
        return ret;
    }
}
