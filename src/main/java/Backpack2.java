public class Solution {
    /*
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     563. Backpack V 

 Description
 Notes
 Testcase
 Judge
Given n items with size nums[i] which an integer array and all positive numbers. An integer target denotes the size of a backpack. Find the number of possible fill the backpack.

Each item may only be used once

Have you met this question in a real interview? Yes
Example
Given candidate items [1,2,3,3,7] and target 7,

A solution set is: 
[7]
[1, 3, 3]

     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
        
        if (j >= nums[i - 1]) {
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
        } else {
            dp[i][j] = dp[i - 1][j];
        }
        
            }
        }
        return dp[n][target];
    }
}

//o(n)

public class Solution {
    /*
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
               dp[j] = dp[j] + (j >= nums[i] ? dp[j- nums[i]] :0);
            }
        }
        return dp[target];
    }
}

//rolling array
public class Solution {
    /*
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            int[] ndp = new int[target + 1];
            for (int j = target; j >= 0; j--) {
               ndp[j] = dp[j] + (j >= nums[i] ? dp[j- nums[i]] :0);
            }
            dp = ndp;
        }
        return dp[target];
    }
}
