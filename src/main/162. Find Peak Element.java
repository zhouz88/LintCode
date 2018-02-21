class Solution {
    public int findPeakElement(int[] nums) {
       int l = 0, r = nums.length - 1;
       while (l <= r) {
           int mid = ((r - l) >> 1) + l;
           if (isPeak(nums, mid)) {
               return mid;
           } else if (isDecrease(nums, mid)) {
               r = mid - 1;
           } else if (isIncrease(nums, mid)){
               l = mid + 1;
           } else if (isBottom(nums, mid)) {
               l = mid + 1;
           }
       }
       return -1;
    }

    private boolean isIncrease(int[] nums, int i) {
        return (i == 0 || nums[i - 1] < nums[i]) && (i < nums.length - 1 && nums[i] < nums[i + 1]);
    }

    private boolean isDecrease(int[] nums, int i) {
        return (i > 0 && nums[i - 1] > nums[i]) && (i == nums.length - 1 || nums[i] > nums[i + 1]);
    }

    private boolean isPeak(int[] nums, int i) {
        return (i == 0 || nums[i - 1] < nums[i]) && (i == nums.length - 1 || nums[i] > nums[i + 1]);
    }

    private boolean isBottom(int[] nums, int i) {
        return (i > 0 && nums[i - 1] > nums[i]) && (i < nums.length - 1 && nums[i] < nums[i + 1]);
    }
}
