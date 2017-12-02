public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     
     92. Backpack 

 Description
 Notes
 Testcase
 Judge
Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

 Notice

You can not divide any item into small pieces.

Have you met this question in a real interview? Yes
Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i][j] =  dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int j = m; j >= 0; j--) {
            if (dp[n][j]) {
                return j;
            }
        }
        return 0;
    }
}


//rolling array
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i <= A.length - 1; i++) {
            boolean[] ndp = new boolean[m + 1];
            for (int j = 0; j <= m; j++) {
                ndp[j] = dp[j];
                if (j - A[i] >= 0) {
                    ndp[j] = ndp[j]||dp[j - A[i]];
                }
            }
            dp = ndp;
        }
        for (int k = m; k>=0;k--) {
            if (dp[k]) {
                return k;
            }
        }
        return -1;
    }
}

//o(n)
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i <= A.length - 1; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i] >= 0) {
                    dp[j] |= dp[j - A[i]];
                }
            }
        }
        for (int k = m; k>=0;k--) {
            if (dp[k]) {
                return k;
            }
        }
        return -1;
    }
}
