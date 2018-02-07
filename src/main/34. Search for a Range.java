class Solution {
    public int[] searchRange(int[] nums, int target) {
        //corner case
        if (nums == null) {
            throw new RuntimeException();
        }
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        //general
        int l = 0, r = nums.length - 1;
        
        //lower bound
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        
        int[] ret = new int[2];
        ret[0] = l;
        //upper bound
        
        l = 0;
        r = nums.length - 1;
        
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        ret[1] = r;
        
        return ret;
    } 
}
