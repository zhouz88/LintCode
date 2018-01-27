import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
http://www.lintcode.com/en/problem/maximum-weighted-sum-path/
*/
public class Solution {
    /**
     * @param nums: the n x m grid
     * @return: the maximum weighted sum
     */
    public int maxWeight(int[][] nums) {
        // write your code here
        if (nums == null || nums.length == 0||nums[0].length == 0) {
            return 0;
        }

        int m = nums.length, n = nums[0].length;
        MAP = new long[m][n];
        for (int i = 0; i  < m; i++) {
            Arrays.fill(MAP[i], Long.MIN_VALUE);
        }
        return (int)dfs(nums, 0, nums[0].length - 1);
    }

    private long[][] MAP;

    public long dfs(int[][] nums, int startX, int startY) {
        if (startX == nums.length - 1 && startY == 0) {
            return nums[startX][startY];
        }
        if (MAP[startX][startY] != Long.MIN_VALUE) {
            return MAP[startX][startY];
        }

        long first = startX+1 <= nums.length - 1 ? dfs(nums, startX +1, startY) + nums[startX][startY] : Long.MIN_VALUE;
        long second = startY-1 >=0 ? dfs(nums, startX, startY - 1) + nums[startX][startY] : Long.MIN_VALUE;

        MAP[startX][startY] = Math.max(first, second);
        return Math.max(first, second);
    }
}
