import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<>();
        long low = (long) lo;
        long high = (long) hi;
        for (int k : a) {
            long num = (long)k;
            if (num == low) {
                low++;
                continue;
            }
            if (low < num) {
                if (num - low == 1) {
                    res.add(low+"");
                } else {
                    res.add(low + "->" + (num - 1));
                }
            }
            low = num + 1;
        }
        if (high - low == 0) {
            res.add(high+"");
        } else if (high - low > 0) {
            res.add(low + "->" + (high));
        }
        return res;
    }
}
