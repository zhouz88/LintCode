import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, ret, new ArrayList<>(), visited);
        return ret;
    }

    private void dfs(int[] nums, List<List<Integer>> ret, List<Integer> objects, boolean[] visited) {
        
        if (objects.size() == nums.length) {
            ret.add(new ArrayList<>(objects));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                objects.add(nums[i]);
                dfs(nums, ret, objects, visited);
                objects.remove(objects.size() - 1);
                visited[i] = false; //wrong 2
            }
        }
    }
}
