163. Missing Ranges
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<>();
        long low = (long)lo;
        long high = (long)hi;
        long p = low;
        
        for (int i = 0; i < a.length; i++) {
            if ((long)a[i] < p) {
                continue;
            }
            if ((long)a[i] == p) {
                p++;
                continue;
            }
            String k = (p == (long)a[i] - 1) ? ""+p:(p + "->" + ((long)a[i] - 1));
            res.add(k);
            p = (long)a[i]+1;
        }
        
        if (p <= high) {
            String k = (p == high) ? ""+p:(p + "->" + (high));
            res.add(k);
        }
        return res;
    }
}

