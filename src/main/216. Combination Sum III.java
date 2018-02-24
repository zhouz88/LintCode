import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        update(res, new ArrayList<>(), k, n, 0, 1);
        return res;
    }

    private void update(List<List<Integer>> res, List<Integer> objects, int k, int n, int sum, int start) {
        if (k < 0 || sum > n) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            objects.add(i);
            sum += i;
            if (sum == n && k - 1 == 0) { //bug 1
                res.add(new ArrayList<>(objects));
            }
            update(res, objects, k - 1, n, sum, i + 1);
            objects.remove(objects.size() - 1);
            sum -= i;
        }
        
    }
}
