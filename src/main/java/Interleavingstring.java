public class Solution {
    /*
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     29. Interleaving String 

 Description
 Notes
 Testcase
 Judge
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Have you met this question in a real interview? Yes
Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (m + n != l) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            if (s3.startsWith(s1.substring(0, i))) {
                dp[i][0] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (s3.startsWith(s2.substring(0, i))) {
                dp[0][i] = true;
            }
        }
        dp[0][0] = true;
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
        int len = i + j - 1;
        if (s3.charAt(len) == s1.charAt(i - 1)) {
            dp[i][j] |= dp[i - 1][j];
        }
        if (s3.charAt(len) == s2.charAt(j - 1)) {
            dp[i][j] |= dp[i][j - 1];
        } 
        }
    }
    return dp[m][n];
    }
}
