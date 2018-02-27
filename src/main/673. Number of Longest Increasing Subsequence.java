import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null ||nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        int[] counts = new int[len];
        Arrays.fill(counts, 1);

        int max = 1, cnt = 0;
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            int cur = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    cur = Math.max(dp[j] + 1, cur);
                }
            }

            dp[i] = cur;
            max = Math.max(cur, max);
            int tmp = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] == cur - 1) {
                    tmp += counts[j];
                }
            }

            counts[i] = Math.max(tmp, counts[i]);
        }
        
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                cnt += counts[i];
            }
        }
        
        return cnt;
    }
}
