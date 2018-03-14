import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
            //general
            Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length;i++) {
            int cur = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    cur = Math.max(dp[j] + 1, cur);
                }
            }
            dp[i] = cur;
        }
        int max = 1;
        for (int k : dp) {
            max = Math.max(k, max);
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < nums.length; i++) {
            if (dp[i] == max) {
                list.add(nums[i]);
                dfs(i, max - 1, dp, nums, res, list);
                break;
            }
        }
        return res;
    }

    private void dfs(int start, int max, int[] dp, int[] nums, List<Integer> res, List<Integer> list) {
        if (res.size() != 0) return;
        if (max == 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                res.add(list.get(i));
            }
            return;
        }
        for (int i = 0; i < start; i++) {
            if (dp[i] == max && list.get(list.size() - 1) % nums[i] == 0) {
                list.add(nums[i]);
                dfs(i, max - 1, dp, nums, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
