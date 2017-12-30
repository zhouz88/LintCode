/*
159. Find Minimum in Rotated Sorted Array 
 Description
 Notes
 Testcase
 Judge
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

 Notice
You may assume no duplicate exists in the array.

Have you met this question in a real interview? Yes
Example
Given [4, 5, 6, 7, 0, 1, 2] return 0



*/
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException();
        
        if (nums.length == 1)
            return nums[0];
        
        int m = nums.length;
        int l = 0, r = m - 1;
        
        while (l <= r) {
            int mid = (l + r)/2;
            boolean flag = (mid == 0 || nums[mid - 1] > nums[mid]);
            if (flag && nums[mid] <= nums[m - 1]) {
                return nums[mid];
            } else if (nums[mid] <= nums[m - 1]) {
                r = mid - 1;
            } else if (nums[mid] >= nums[0]) {
                l = mid + 1;
            }
        }
        
        throw new RuntimeException();
    }
}
