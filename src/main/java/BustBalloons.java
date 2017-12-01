import java.util.*;

public class Solution {
    /*
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     168. Burst Balloons 

 Description
 Notes
 Testcase
 Judge
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.
- You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
- 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Have you met this question in a real interview? Yes
Example
Given [4, 1, 5, 10]
Return 270

nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
nums = [4, 5, 10]    burst 5, get coins 4 * 5 * 10 = 200 
nums = [4, 10]       burst 4, get coins 1 * 4 * 10 = 40
nums = [10]          burst 10, get coins 1 * 10 * 1 = 10

Total coins 20 + 200 + 40 + 10 = 270
     */
    public int maxCoins(int[] nums) {
        // write your code here
        int n = nums.length;
        int[] A = new int[n + 2];
        A[0] = 1;
        A[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            A[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int delta = 1; delta <= n + 1; delta++) {
            for (int i = 0; i <= n; i++) {
                int j = i + delta;
                if (j >= n+2)continue;
                for (int k = i + 1; k < j; k++) {
        dp[i][j] = Math.max(dp[i][k] + A[k]*A[j]*A[i] + dp[k][j], dp[i][j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
