import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();

        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int i, j, x;
        x = 0;
        int max = 1;
        for (i = 1; i < nums.length; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
            if (dp[i] == max) {
                x = nums[i];
            }
        }
        ret.add(x);
        dfs(dp, max, ret, nums, x);
        return ret;
    }

    private void dfs(int[] dp, int max, List<Integer> list, int[] nums, int x) {
        if (max == 1) {
            return;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max - 1 && x%nums[i] ==0) {
                list.add(nums[i]);
                dfs(dp, max - 1, list, nums, nums[i]);
                break;
            }
        }
    }
}
