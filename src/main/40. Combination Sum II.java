import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //本质上和3sum是一道题~~只不过要用递归。 O(n * 2^n)
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        update(ret, candidates, target, new ArrayList<>(), 0, 0);
        return ret;
    }

private void update(List<List<Integer>> ret, int[] candidates, int target, ArrayList<Integer> objects, int total, int start) {
    
        if (total > target) {
            return;
        }
        if (total == target) {
            ret.add(new ArrayList<>(objects));
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            total += candidates[i];
            objects.add(candidates[i]);
            update(ret, candidates, target, objects, total, i  + 1);
            total -= candidates[i];
            objects.remove(objects.size() - 1);
        }
    }
}
