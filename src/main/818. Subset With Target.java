import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    /**
     * @param nums: the array
     * @param target: the target
     * @return: the number of subsets which meet the following conditions
     */
    public long subsetWithTarget(int[] nums, int target) {
        // Write you code here
        Arrays.sort(nums);
        long cnt = 0;

        TreeMap<Long, Long> map = new TreeMap<>();

        for (int k : nums) {
            map.put((long)k, map.getOrDefault((long)k,0L) + 1L);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int tar = target - nums[i] - 1;
            int l = i + 1;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r)/2;
                if (nums[mid] == tar) {
                    l = mid + 1;
                } else if (nums[mid] < tar) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            long tmp = map.get((long)nums[i]);

            if (nums[r] == nums[i]) {
                if (nums[i]*2 < target) {
                    cnt += (long)((long)(1 << tmp) - 1L);
                }
                continue;
            }
            for (long k : map.subMap(nums[i] + 1L, true, (long)nums[r], true).keySet()) {
                long total = map.get(k);
                tmp *= (long)(1 << total);
            }
            
            cnt += tmp;
        }
        return (long)cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetWithTarget(new int[]{1,2,3,4,5}, 5));
    }
}
