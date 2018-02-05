class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int pre = nums[0];
        int cnt = 1;
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
                if (cnt == 2) {
                    nums[idx++] = nums[i];
                }
            } else {
                cnt = 1;
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
