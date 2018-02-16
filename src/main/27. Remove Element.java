import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        Arrays.fill(nums, j, nums.length, 0);
        return j;
    }
}
