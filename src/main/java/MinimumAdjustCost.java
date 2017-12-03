public class Solution {
    /*
     * @param A: An integer array
     * @param target: An integer
     91. Minimum Adjustment Cost 

 Description
 Notes
 Testcase
 Judge
Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

 Notice

You can assume each number in the array is a positive integer and not greater than 100.

Have you met this question in a real interview? Yes
Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.

Tags 
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        if (A == null) {
            return 0;
        }
        
        int n = A.size();
        if (n == 0) {
            return 0;
        }
        
        int[][] dp = new int[n + 1][101];
        
        for (int i = 1; i <= 100; i++) {
            dp[1][i] = Math.abs(A.get(0) - i);//把第0个数改为i的代价
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1 ;k <= 100; k++) {
                    if (Math.abs(k - j) <= target) {
    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i - 1) - j));
                    }//把第i-1个数改为j的代价
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= 100; i++){
            min = Math.min(min, dp[n][i]);
        }
        return min;
    }
}
