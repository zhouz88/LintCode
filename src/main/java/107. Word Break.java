import java.util.Set;

public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int i , j;
        int maxLen = 0;
        for (String k : dict) {
            maxLen = Math.max(k.length(), maxLen);
        }
        for (i = 1; i < dp.length; i++) {
            for (j = Math.max(0, i - maxLen); j < i; j++) {
                if (dp[j]) {
                    dp[i] = dict.contains(s.substring(j, i));
                }
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
