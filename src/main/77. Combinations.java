import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        update(ret, k, 1, n, new ArrayList<>());
        return ret;
    }

    private void update(List<List<Integer>> ret, int k, int start, int n, ArrayList<Integer> objects) {
        if (objects.size() == k) {
            ret.add(new ArrayList<>(objects));
            return;
        }
        if (objects.size() + n - start + 1 < k) {//pruning !!!!!!!!!!!!!
            return;
        }
        for (int i = start; i <= n; i++) {
            objects.add(i);
            update(ret, k, i + 1, n, objects);
            objects.remove(objects.size() - 1);
        }
    }
}
