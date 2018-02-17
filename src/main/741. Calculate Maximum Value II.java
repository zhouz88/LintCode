import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * @param str: a string of numbers
     * @return: the maximum value
     */
    public int maxValue(String str) {
        // write your code here
        int[][] dp = new int[str.length()][str.length()];
        int len = str.length();
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = str.charAt(i) - '0';
        }

        for (int delta = 1; delta < len; delta++) {
            for (int i = 0; i < str.length(); i++) {
                int j = Math.min(str.length() - 1, i + delta);
                for (int k = i; k < j; k++) {
    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k] + dp[k + 1][j], dp[i][k] * dp[k + 1][j]));
                }
            }
        }

        return dp[0][str.length() - 1];
    }
}
