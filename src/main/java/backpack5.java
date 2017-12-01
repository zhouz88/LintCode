public class Solution {
    /*
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     
     440. Backpack III 

 Description
 Notes
 Testcase
 Judge
Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with size m. What's the maximum value can you put into the backpack?

 Notice

You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Have you met this question in a real interview? Yes
Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 15.
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
