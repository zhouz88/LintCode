import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {

        //corner case;
        if (nums == null || nums.length == 0) {
            return;
        }
        int idx = 0;
        int cnt = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            } else {
                cnt++;
            }
        }
        Arrays.fill(nums, idx, nums.length, 0);
    }
}
