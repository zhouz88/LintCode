import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int i , j;
        int len = nums.length;
        Arrays.sort(nums);//sorting
        for (i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = len - 1;//wrong 2
                while (l < r) {
                    int total = nums[i] + nums[j] + nums[l] + nums[r];
                    if (total == target) {
                        ret.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while (l + 1 < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        while (r - 1 > l && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (total > target) {
                        r--;
                    } else if (total < target) {
                        l++;
                    }
                }
            }
        }
        return ret;
    }
}
