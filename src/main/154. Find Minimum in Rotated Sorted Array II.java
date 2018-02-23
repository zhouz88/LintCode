class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (nums[end] == nums[mid]) {
                end--;
                continue;
            }
            
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            
            if (nums[mid] < nums[end]) {
                end = mid;
            }
            else {
                start = mid;   
            }
        }
        
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
