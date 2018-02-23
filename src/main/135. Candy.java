import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        int sum = 0;
        Arrays.fill(dp ,1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i + 1] + 1, dp[i]);//key 
            }
        }
        for (int k : dp) {
            sum += k;
        }
        return sum;
    }
}
