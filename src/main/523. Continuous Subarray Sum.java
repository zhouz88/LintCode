import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum) && i - map.get(sum) >= 2) {
                    return true;
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int tmp = sum%k;
            if (map.containsKey(tmp) && i - map.get(tmp) >= 2) {
                return true;
            }
            if (!map.containsKey(tmp)) {
                map.put(tmp, i);
            }
        }
        return false;
    }
}
