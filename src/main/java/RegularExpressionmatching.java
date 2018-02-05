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
        s = " " + s;
        p = " " + p;
        int m = s.length(), n = p.length();

        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '*') {
                    if (j >= 1 && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                        if (i >= 1) dp[i][j] |= dp[i - 1][j];
                        if (j >= 2) dp[i][j] |= dp[i][j - 2];
                    } else {
                        if (j >= 2) dp[i][j] |= dp[i][j - 2];
                    }
                } else {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        if (i >= 1 && j >= 1) dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (j >= 1 && p.charAt(j - 1) == '*') {
                    if (j >= 2) dp[i][j] |= dp[i][j - 2];
                    if (j >= 2 && i >= 1 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else if (j > 0 && i > 0 && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        int i, j;
        for (j = 1; j < p.length(); j+=2) {
            if (p.charAt(j - 1) != '*' && p.charAt(j) == '*') {
                dp[0][j + 1] = true;
            } else {
                break;
            }
        }
        for (i = 0; i < s.length(); i++) {
            for (j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*' && j > 0) {
                    if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                } else if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
