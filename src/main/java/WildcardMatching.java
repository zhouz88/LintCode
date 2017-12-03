public class Solution {
	/*
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     192. Wildcard Matching 

 Description
 Notes
 Testcase
 Judge
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Have you met this question in a real interview? Yes
Example
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
Tags 
     */
	public boolean isMatch(String s, String p) {
		// write your code here
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		s = " " + s;
		p = " " + p;
		for (int i = 1; i <= p.length() -1 ; i++) {
		    if (p.charAt(i) == '*') {
		        dp[0][i] = true;
		    } else break;
		}
for (int i = 1; i <= m; i++) {
 	for (int j = 1; j <= n; j++) {
		if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
			dp[i][j] = dp[i - 1][j - 1];
		} else if (p.charAt(j) == '*') {
			dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
		} 
	}
 }
 return dp[m][n];
		
	}
}
