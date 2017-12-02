
public class Solution {
	/*
     * @param strs: an array with strings include only 0 and 1
     * @param m: An integer
     * @param n: An integer
     * @return: find the maximum number of strings
     668. Ones and Zeroes 

 Description
 Notes
 Testcase
 Judge
In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.


     */
	public int findMaxForm(String[] strs, int m, int n) {
		// write your code here
	    int l = strs.length;
	    int[][][] dp = new int[l + 1][m + 1][n + 1];
	    for (int i = 1; i <= l; i++) {
	        for (int j = 0; j <= m; j++) {
	            for (int k = 0; k <= n; k++) {
	                if (j >= getZero(strs[i - 1]) && k >= getOne(strs[i - 1])) {
dp[i][j][k] = Math.max(dp[i - 1][j][k], 1 + dp[i - 1][j - getZero(strs[i - 1])][k - getOne(strs[i - 1])]);
	                } else {
	                    dp[i][j][k] = dp[i - 1][j][k];
	                }
	            }
	        }
	    }
	    return dp[l][m][n];
	}
	
	private int getOne(String s) {
	    int count = 0;
	    for (char ch : s.toCharArray()) {
	        if (ch == '1') count++;
	    }
	    return count;
	}
	
	private int getZero(String s) {
	    int count = 0;
	    for (char ch : s.toCharArray()) {
	        if (ch == '0') count++;
	    }
	    return count;
	}
}
