class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1;
        int[] dp = new int[k];
        for (int i = 0; i < n; i++) {
            int[] array = new int[k];
            int lastMin1 = min1, lastMin2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < k; j++) {
                if (lastMin1 != j) {
                    array[j] = (lastMin1 == -1 ? 0 : dp[lastMin1]) + costs[i][j];
                } else {
                    array[j] = (lastMin2 == -1 ? 0 : dp[lastMin2]) + costs[i][j];
                }
                if (min1 == -1|| array[j] < array[min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || array[j] < array[min2]) {
                    min2 = j;
                }
            }
            dp = array;
        }
        return dp[min1];
    }
}
