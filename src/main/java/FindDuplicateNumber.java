public class Solution {
    /*
    633. Find the Duplicate Number 
 Description
 Notes
 Testcase
 Judge
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Notice
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n^2).
There is only one duplicate number in the array, but it could be repeated more than once.
Have you met this question in a real interview? Yes
Example
Given nums = [5,5,4,3,2,1] return 5
Given nums = [5,4,4,3,2,1] return 4

Tags 
Related Problems 
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // Write your code here
        int start = 1;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = (start + end)/2;
            if (check_smaller_num(mid, nums) <= mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return start;
    }
    
    public int check_smaller_num(int mid, int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= mid){
                cnt++;
            }
        }
        return cnt;
    }
}
