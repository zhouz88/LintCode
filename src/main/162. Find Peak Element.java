class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l)/2 + l;
            if (peak(mid, nums)) {
                return mid;
            } else if (increasing(mid, nums)) {
                l = mid + 1;
            } else if (decreasing(mid, nums)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private boolean decreasing(int mid, int[] nums) {
        return (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) && (mid > 0 || nums[mid - 1] > nums[mid]);
    }

    private boolean increasing(int mid, int[] nums) {
        return (mid == 0 || nums[mid - 1] < nums[mid]) && (mid < nums.length - 1 && nums[mid] < nums[mid + 1]);
    }

    private boolean peak(int mid, int[] nums) {
        return (mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]);
    }
}
