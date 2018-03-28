import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            Integer low = map.get(nums[i] - 1);
            Integer high = map.get(nums[i] + 1);
            int total = 1;
            total += (low == null ? 0 : low);
            total += (high == null ? 0 : high);
            map.put(nums[i], total);
            if (low != null) {
                map.put(nums[i] - low, total);
            }
            if (high != null) {
                map.put(nums[i] + high, total);
            }
            max = Math.max(max, total);
        }
        return max;
    }
}
