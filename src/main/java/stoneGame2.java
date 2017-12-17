public class Solution {
    /*
     * @param A: An integer array
     * @return: An integer
      593. Stone Game II

    Description
    Notes
    Testcase
    Judge

There is a stone game.At the beginning of the game the player picks n piles of stones in a circle.

The goal is to merge the stones in one pile observing the following rules:

At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.
Have you met this question in a real interview?
Example

For [4, 1, 1, 4], in the best solution, the total score is 18:

1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10

Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43

     */
    public int stoneGame2(int[] A) {
        // write your code here
        if (A == null) {
            throw new RuntimeException();
        }
        if (A.length == 0) {
            return 0;
        }
        
        int m = A.length;
        int[][] M = new int[m][m];
        
        int min  = 999999999;
        for (int i = 0; i < m; i++) {
            int[] B = M[i];
            int j = 0;
            for (; j + i <= m - 1; j++) {
                B[j] = A[i + j];
            }
            for (j = m - i; j <= m - 1; j++) {
                B[j] = A[i + j - m];
            }
            min = Math.min(min, stoneGame(B));
        }
        return min;
    }
    
    public int stoneGame(int[] A) {
        // write your code here
        if (A == null) {
            throw new RuntimeException();
        }
        
        int m = A.length;
        if (m == 0) {
            return 0;
        }
        int[][] dp = new int[m][m];
        int[] sum = new int[m + 1];
        
        for (int i = 1; i <= m; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        
        //sum(i, j) = sum[j+ 1] - sum[i];
        
        for (int len = 1; len <= m; len++) {
            for (int i = 0; i <= m; i++) {
                int j = i + len;
                if (j <= m - 1) {
                    dp[i][j] = 999999999;
                    for (int k = i; k < j; k++) {
    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                    }
                }
            }
        }
        
        return dp[0][m - 1];
}
}
