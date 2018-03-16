import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int max = 1 << nums.length;
        for (int i = 0; i < max; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++){
                if ((1 << j & i) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
