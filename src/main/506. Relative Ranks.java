import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Integer[] res = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = i;
        }
        Arrays.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(nums[o2], nums[o1]);
            }
        });
        int n = 1;
        for (int i = 0; i < res.length; i++) {
            nums[res[i]] = n++;
        }
        String[] ret = new String[nums.length];
        for (int i = 0; i < res.length; i++) {
            ret[i] = nums[i]+"";
            if (nums[i] == 1) {
                ret[i] = "Gold Medal";
            } else if (nums[i] == 2) {
                ret[i] =  "Silver Medal";
            } else if (nums[i] == 3) {
                ret[i] = "Bronze Medal";
            }
        }
        return ret;
    }
}
