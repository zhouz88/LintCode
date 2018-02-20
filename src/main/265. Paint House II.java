class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null ||costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length, k = costs[0].length;
        int[] dp = costs[0];
        
        int minIdx = 0, secondIdx = -1, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for (int i = 0; i < k; i++) {
            if (dp[i] < min1) {
                min2 = min1;
                secondIdx = minIdx;
                min1 = dp[i];
                minIdx = i;
            } else if (dp[i] <= min2) {
                min2 = dp[i];
                secondIdx = i;
            }
        }
        
        for (int i = 1; i < n; i++) {
            int[] newDp = new int[k];
            int newMinIdx = -1;
            int newSecondMinIdx = -1;
            int minValue1 = Integer.MAX_VALUE;
            int minValue2 = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                if (j != minIdx) {
                    newDp[j] = costs[i][j] + dp[minIdx];
                } else {
                    newDp[j] = costs[i][j] + dp[secondIdx];
                }
                
                if (newDp[j] < minValue1) {
                    newSecondMinIdx = newMinIdx;
                    minValue2 = minValue1;
                    newMinIdx = j;
                    minValue1 = newDp[j];
                
                } else if (newDp[j] <= minValue2) {
                    newSecondMinIdx = j;
                    minValue2 = newDp[j];
                }
            }

            minIdx = newMinIdx;
            secondIdx = newSecondMinIdx;
            dp = newDp;
        }

        return dp[minIdx];
    }
}
