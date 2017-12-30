/*

33. Search in Rotated Sorted Array
DescriptionHintsSubmissionsDiscussSolution

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int m = nums.length;
        int l = 0, r = m - 1;
        if (nums[0] < nums[r]) {
            while (l <= r) {
                int mid = (l + r)/2;
                if (nums[mid] == target) 
                    return mid;
                else if (nums[mid] < target) 
                    l = mid + 1;
                else 
                    r = mid - 1;
            }
            return -1;
        }
        
        while (l <= r) {
            int mid = (l + r)/2;
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] >= nums[0]) {
                if (target < nums[mid] && target >= nums[0]) 
                    r = mid - 1;
                else
                    l = mid + 1;
            } 
            
            if (nums[mid] <= nums[nums.length - 1]) {
                if (target > nums[mid] && target <= nums[nums.length - 1]) 
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        
        return -1;
    }
}
