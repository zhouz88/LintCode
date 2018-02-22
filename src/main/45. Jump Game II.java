class Solution {
    public int jump(int[] nums) {
        int i = 0, len = nums.length;
        int l = 0, r = 0;
        int step = 0;
        if (len == 1) {
            return 0;
        }
        while(true) {
            int max = -1;
            step++;
            for (int j = l; j <= r; j++) {
                if (j + nums[j] >= len - 1) {
                    return step;
                } else if (j + nums[j] > r) {
                    l = r + 1;
                    max = Math.max(j + nums[j], max);
                }
            }
            r = max;
        }
    }
}
