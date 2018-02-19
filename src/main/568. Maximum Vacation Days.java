import java.util.Arrays;

class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int i, j, k;
        for (i = 0; i < n; i ++) {
            flights[i][i] = 1;
        }
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        for (j = 0; j < n; j++) {
            if (flights[0][j] == 1) {
                dp[j] = days[j][0];//wrong 1
            }
        }
        
        for (i = 1; i < days[0].length; i++) {
            int[] newDp = new int[n];
            Arrays.fill(newDp, -1);
            for (j = 0; j < n ; j++) {
                if (dp[j] == -1) continue;
                for (k = 0; k < n; k++) {
                    if (flights[j][k] == 1) {
                        newDp[k] = Math.max(newDp[k], dp[j] + days[k][i]); //wrong 2
                    }
                }
            }
            dp = newDp;
        }
        
        int ans = -1;
        
        for (i = 0; i < n; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                ans = Math.max(ans, dp[i]);
            }
        }
        
        return ans;
    }
}
