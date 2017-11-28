public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
     
     /*
     108. Palindrome Partitioning II 

 Description
 Notes
 Testcase
 Judge
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.


     */
    public int minCut(String s) {
        // write your code here
        if (s.length() <= 1) {
            return 0;
        }
        boolean[][] isPa = getIsPa(s);
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (isPa[j][i]) {
                    int k = (j - 1 < 0 ? 0 :dp[j - 1] + 1);
                    dp[i] = Math.min(dp[i], k);
                }
            }
        }
        return dp[s.length() - 1];
    }
    
    public boolean[][] getIsPa(String s) {
        int n = s.length();
        boolean[][] isPa = new boolean[s.length()][s.length()];
        for (int i = 0; i < n; i++) {
            isPa[i][i] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isPa[i][j] = (j - i == 1 ? true : isPa[i + 1][j - 1]);
                }
            }
        }
        return isPa;
    }
};
