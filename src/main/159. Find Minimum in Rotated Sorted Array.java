class Solution {
    public int findMin(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int l = 0, r= nums.length - 1;
        
        if (nums[l] <= nums[r]){
            return nums[l];
        }
        
        while (l <= r) {
            int mid = (r - l)/2 + l;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } 
            if (nums[mid] >= nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return 0;
    }
}
