class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int l = binarySearch(dp, 0, len - 1, nums[i]);
            dp[l] = nums[i];
            if (l == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] dp, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start)/2 + start;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
