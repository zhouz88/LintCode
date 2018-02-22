class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, len = nums.length;
        int l = 0, r = 0;
        int step = 0;
        if (len == 1) {
            return true;
        }
        while(true) {
            int max = -1;
            step++;
            for (int j = l; j <= r; j++) {
                if (j + nums[j] >= len - 1) {
                    return true;
                } else if (j + nums[j] > r) {
                    l = r + 1;
                    max = Math.max(j + nums[j], max);
                }
            }
            r = max;
            if (r == -1) {
                return false;
            }
        }
    }
}
