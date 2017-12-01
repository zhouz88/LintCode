public class Solution {
    /*
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     430. Scramble String 

 Description
 Notes
 Testcase
 Judge
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Have you met this question in a real interview? Yes

     */
    public boolean isScramble(String s1, String s2) {
        // write your code here
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j][1] = true;
                    }
                }
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n-k; i++) {
                for (int j = 0; j <= n-k; j++) {
                    for (int w = 1; w <= k - 1; w++) {
   dp[i][j][k] = dp[i][j][k] || (dp[i][j][w] && dp[i+w][j+w][k-w]);
   dp[i][j][k] = dp[i][j][k] || (dp[i][j+k-w][w] && dp[i+w][j][k-w]);
                    }
                }
            }
        }
        return dp[0][0][n];
        
        /*
f[i][j][k] = OR1<=w<=k-1{f[i][j][w] AND f[i+w][j+w][k-w]} OR
OR1<=w<=k-1{f[i][j+k-w][w] AND f[i+w][j][k-w]}
*/
    }
}
