class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null ||costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int n = costs.length, k = costs[0].length;
        int[] dp = costs[0];
        int minIdx = 0;
        int secondIdx = 0;

        for (int i = 1; i < k; i++) {
            if (dp[i] < dp[minIdx]) {
                minIdx = i;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            if (minIdx == i) {
                continue;
            } else {
                if (dp[i] < min) {
                    min = dp[i];
                    secondIdx = i;
                }
            }
        }
        
        for (int i = 1; i < n; i++) {
            int[] newDp = new int[k];
            int newMinIdx = -1;
            int newSecondMinIdx = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                if (j != minIdx) {
                    newDp[j] = costs[i][j] + dp[minIdx];
                } else {
                    newDp[j] = costs[i][j] + dp[secondIdx];
                }
                if (newDp[j] < minValue) {
                    newMinIdx = j;
                    minValue = newDp[j];
                }
            }

            minValue = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                if (newMinIdx == j) {
                    continue;
                } else {
                    if (newDp[j] < minValue) {
                        minValue = newDp[j];
                        newSecondMinIdx = j;
                    }
                }
            }

            minIdx = newMinIdx;
            secondIdx = newSecondMinIdx;
            dp = newDp;
        }

        return dp[minIdx];
    }
}
