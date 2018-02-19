import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 2) {
                return true;
            }
            if (i - k >= 0) {
                map.put(nums[i - k], map.get(nums[i - k]) - 1); //wrong 1
                if (map.get(nums[i - k]) == 0) {
                    map.remove(nums[i - k]);
                }
            }
        }
        return false;
    }
}
