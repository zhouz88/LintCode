public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     118. Distinct Subsequences 

 Description
 Notes
 Testcase
 Judge
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Have you met this question in a real interview? Yes
Example
Given S = "rabbbit", T = "rabbit", return 3.
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i<= m;i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
dp[i][j] = ((S.charAt(i - 1) == T.charAt(j - 1) ?dp[i - 1][j - 1] : 0)) + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
};
