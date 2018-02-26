class Solution {
    public int maxProduct(int[] nums) {
        
        //corner case
        if (nums == null || nums.length < 1)
             return 0;
        //
        int[] dp = new int[nums.length];
        int[] dpN = new int[nums.length];
        
        dpN[0] = nums[0];
        dp[0] = nums[0];
        int max = nums[0];
        
        for (int i = 1;  i< nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], dpN[i - 1] * nums[i]);
            dp[i] = Math.max(dp[i], nums[i]);
            dpN[i] = Math.min(nums[i], nums[i]*dpN[i - 1]);
            dpN[i] = Math.min(dpN[i], nums[i]*dp[i - 1]);
            max = Math.max(dp[i], max);
        } 
        return max;
    }
}

//
class Solution {
    public int maxProduct(int[] nums) {
        if (nums== null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int max = nums[0];
        int curMax = max, curMin = max;
        for (int i = 1; i < len; i++) {
            int lo = curMin * nums[i];
            int hi = curMax * nums[i];
            curMax = Math.max(lo, Math.max(hi, nums[i]));
            curMin = Math.min(lo, Math.min(hi, nums[i]));
            max = Math.max(max, curMax);
        }
        return max;
    }
}
