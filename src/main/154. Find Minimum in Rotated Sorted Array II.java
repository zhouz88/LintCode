class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[0] < nums[r]) {
            return nums[0];
        }
        while (l + 1 < r) {
            int mid = (r - l)/2 + l;
        
            if (nums[mid] == nums[r]) {
                r--;
                continue;
            }
            if (nums[mid] == nums[l]) {
                l++;
                continue;
            }
            if (nums[mid] > nums[l]) {
                l = mid;
                
            } else if (nums[mid] < nums[r]) {
                r = mid;
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}
