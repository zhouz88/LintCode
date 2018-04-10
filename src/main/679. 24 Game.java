import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            list.add(1.0*nums[i]);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24) < 1e-6) return true;
            else return false;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) next.add(list.get(k));
                }
                double first = list.get(i) + list.get(j);
                double second = list.get(i) - list.get(j);
                double third = list.get(i) * list.get(j);
                Double forth = list.get(j) == 0 ? null : list.get(i)/list.get(j);
                next.add(first);
                if (solve(next)) {
                    return true;
                }
                next.remove(next.size() - 1);
                next.add(second);
                if (solve(next)) {
                    return true;
                }
                next.remove(next.size() - 1);
                next.add(third);
                if (solve(next)) {
                    return true;
                }
                next.remove(next.size() - 1);
                if (forth != null) {
                    next.add(forth);
                    if (solve(next)) {
                        return true;
                    }
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}
