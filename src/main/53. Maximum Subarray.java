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
