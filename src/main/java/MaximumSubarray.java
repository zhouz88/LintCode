public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     41. Maximum Subarray 

 Description
 Notes
 Testcase
 Judge
Given an array of integers, find a contiguous subarray which has the largest sum.

 Notice

The subarray should contain at least one number.

Have you met this question in a real interview? Yes
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int m = nums.length;
        if (m == 0) {
            return 0;
        }
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < m; i++) {
            pre  = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
