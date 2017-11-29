public class Solution {
    /*
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     564. Backpack VI 

 Description
 Notes
 Testcase
 Judge
Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

 Notice

A number in the array can be used multiple times in the combination. 
Different orders are counted as different combinations.

Have you met this question in a real interview? Yes
Example
Given nums = [1, 2, 4], target = 4

The possible combination ways are:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[2, 1, 1]
[2, 2]
[4]
return 6
     */
    public int backPackVI(int[] nums, int target) {
        // write your code here
        int[] dp = new int[200000];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int k : nums) {
                if (i >= k) dp[i] += dp[i - k];
            }
        }
        return dp[target];
    }
}
