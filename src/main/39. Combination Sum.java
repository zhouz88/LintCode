import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        update(ret, candidates, 0, target, new ArrayList<>(), 0);
        return ret;
    }

    private void update(List<List<Integer>> ret, int[] candidates, int start, int target, ArrayList<Integer> objects, int sum) {
        if (sum == target) {
            ret.add(new ArrayList<>(objects));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            objects.add(candidates[i]);
            update(ret, candidates, i, target, objects, sum);
            sum -= candidates[i];
            objects.remove(objects.size() - 1);
        }
    }
}
