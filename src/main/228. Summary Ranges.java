import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        //edge case
        if (nums == null || nums.length == 0) { //bug 1
            return res;
        }
        if (nums.length == 1) {
            res.add(""+nums[0]);
            return res;
        }
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) { //bug 2
                cnt++;
            } else {
                if (cnt > 1) {
                    int start = i - cnt;
                    res.add(nums[start] + "->" + nums[i - 1]);//bug3 + bug4 + bug5
                } else {
                    res.add(""+nums[i - 1]);
                }
                cnt = 1;
            }
        }
        if (cnt > 1) {
            int start = nums.length - cnt;
            res.add(nums[start] + "->" + nums[nums.length - 1]);
        } else {
            res.add(""+nums[nums.length - 1]);
        }
        return res;
    }
}
