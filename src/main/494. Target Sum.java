class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int total = 0;
        int len = nums.length;
        for (int num : nums) {
            total += num;
        }
        if (total < S) {//wrong 1 wrong2 neglect this cases
            return 0;
        }
        if ((total & 1) != (S & 1)) {
            return 0;
        }
        
        S += total;
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * 2;
        }
        
        int[][] dp = new int[len + 1][S + 1];

        dp[0][0] = 1;
        int i, j;

        for (i = 1; i <= len; i++ ) {
            for (j = 0; j <= S; j++) {
                dp[i][j] = (j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] : 0) + dp[i - 1][j];
            }
        }
        
        return dp[len][S];
    }
}
