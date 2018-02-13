class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[] ret = new int[3];
        ret[0] = costs[0][0];
        ret[1] = costs[0][1];
        ret[2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int[] dp = new int[3];
            dp[0] = Math.min(costs[i][0] + ret[1], costs[i][0] + ret[2]);
            dp[1] = Math.min(costs[i][1] + ret[0], costs[i][1] + ret[2]);
            dp[2] = Math.min(costs[i][2] + ret[0], costs[i][2] + ret[1]);
            ret = dp;
        }
        Arrays.sort(ret);
        return ret[0];
    }
}
