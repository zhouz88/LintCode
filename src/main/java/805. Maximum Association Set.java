import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param ListA: The relation between ListB's books
     * @param ListB: The relation between ListA's books
     * @return: The answer
     */
    public List<String> maximumAssociationSet(String[] ListA, String[] ListB) {
        if (ListA.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (String k : ListA) {
            if (!map.containsKey(k)) {
                map.put(k, idx++);
            }
        }
        for (String k : ListB) {
            if (!map.containsKey(k)) {
                map.put(k, idx++);
            }
        }
        int n = map.size();
        int[] f = new int[n];
        int[] counts = new int[n];
        for (int i = 1; i < n; i++) {
            f[i] = i;
            counts[i] = 1;
        }
        for (int i = 0; i < ListA.length; i++) {
            int a = map.get(ListA[i]);
            int b = map.get(ListB[i]);
            int fa = find(a, f);
            int fb = find(b, f);
            if (fa != fb) {
                f[fb] = fa;
                counts[fa] += counts[fb];
            }
        }
        int max = 1;
        for (int k : counts) {
            max = Math.max(k, max);
        }
        List<String> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            int value = e.getValue();
            int fa = find(value, f);
            if (counts[fa] == max) {
                ret.add(e.getKey());
            }
        }
        return ret;
    }
    
    public int find(int start, int[] f) {
        while (start != f[start]) {
            start = f[start];
        }
        return start;
    }
}
