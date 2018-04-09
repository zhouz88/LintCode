class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length][K];
        //dp[i][j] i 表示瓜分A【i】和A【i】以前用了j次；失败原因是初始条件没弄清除

        for (int j = 0; j < K; j++) {
            for (int i = 0; i < A.length; i++) {
                double cur = Double.NEGATIVE_INFINITY;
                double total = 0;
                if (j > 0)  {
                    for (int k = i; k >= j; k--) {
                        total += A[k];
                        cur = Math.max(cur, dp[k - 1][j - 1]  + (total) / (i - k + 1));
                    }
                } else {
                    for (int k = i; k >= 0; k--) {
                        total += A[k];
                    }
                    cur = (total) / (i + 1);
                }
                dp[i][j] = cur;
            }
        }
        return dp[A.length - 1][K - 1];
    }
}
