
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        ret.add(new ArrayList<>());
        dfs(ret, new ArrayList<>(), nums, 0);
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, List<Integer> list, int[] nums, int start) {
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);           
            ret.add(new ArrayList<>(list));//wrong 1
            dfs(ret, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
