import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == target) {
                    return target; //wrong2
                } else if (nums[i] + nums[l] + nums[r] < target) {
                    int tmp = Math.abs(nums[i] + nums[l] + nums[r] - target);
                    if (tmp < ret) {
                        ret = tmp;
                        ans = nums[i] + nums[l] + nums[r];
                    }
                    l++;
                } else {
                    int tmp = Math.abs(nums[i] + nums[l] + nums[r] - target);
                    if (tmp < ret) {
                        ret = tmp;
                        ans = nums[i] + nums[l] + nums[r]; //wrong 1
                    }
                    r--;
                }
            }
        }
        return ans;
    }
}
