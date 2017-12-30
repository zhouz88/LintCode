public class Solution {
    /*
    406. Minimum Size Subarray Sum 
 Description
 Notes
 Testcase
 Judge
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

Have you met this question in a real interview? Yes
Example
Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

Challenge 
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
     
    o(n) double pointers
    
    public int minimumSize(int[] nums, int s) {
        // write your code here
        
        
        if (nums == null) 
            throw new RuntimeException();
            
        if (nums.length == 0) 
            return -1;
        
        int j = 0;
        int total = 0;
        int min = 999999999;
        
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            while (total >= s) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                }
                total -= nums[j];
                j++;
            }
        }
        
        return min == 999999999 ? -1 : min;
    }
    
    
    
    
    //nlog(n)
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) 
            return -1;
            
        int r = nums.length;
        int l = 1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (check(mid, nums, s)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l <= nums.length ? l : -1;
    }
    
    private boolean check(int len, int[] nums, int s) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (i + 1 >= len) {
                if (total >= s) 
                    return true;
                    
                total -= nums[i - len + 1];
            }
        }
        return false;
    }
    
}
