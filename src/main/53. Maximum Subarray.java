class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new  int[nums.length];
        int max = nums[0];
        dp[0] = max;//wrong 1
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);//wrong 2
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

//
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        int maxAns = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxAns = Math.max(maxAns, pre);
        }
        
        return maxAns;
    }
}
