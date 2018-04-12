import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int cnt = 1;
        if (nums.length == 0) return res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {// bug1
                cnt++;
            } else {
                int first = nums[i - cnt];
                int second = nums[i - 1];
                res.add(first == second ? ""+first: first + "->" + second);
                cnt = 1;
            }
        }
        int first = nums[nums.length - cnt];
        int second = nums[nums.length - 1];
        res.add(first == second ? ""+first: first + "->" + second);
        return res;
    }
}
