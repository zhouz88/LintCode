/*

154. Regular Expression Matching 

 Description
 Notes
 Testcase
 Judge
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(string s, string p)
Have you met this question in a real interview? Yes
Example
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        s = " " + s;
        p = " " + p;
    for (int i = 0; i <= m; i++) {
        for (int j = 1; j <= n ; j++) {
        if (j > 1 && p.charAt(j) == '*') {
            if (p.charAt(j-1) == '.' || p.charAt(j-1)  == s.charAt(i)) {
                dp[i][j] = (j >= 2 && dp[i][j-2]) || (i >= 1 && dp[i-1][j]);
            } else {
                dp[i][j] = (j >= 2 && dp[i][j-2]);
            }
        }
        if (i > 0 && p.charAt(j) != '*') {
            dp[i][j] = (p.charAt(j)  == s.charAt(i) || p.charAt(j) == '.'? dp[i-1][j-1] : false);
        }
        }
    }
        return dp[m][n];
    }
}
