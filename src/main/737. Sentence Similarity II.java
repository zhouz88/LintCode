import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        HashSet<String> set = new HashSet<>();
        
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        
        for (String[] k : pairs) {
            map.putIfAbsent(k[0], id++);
            map.putIfAbsent(k[1], id++);
        }
        
        int[] f = new int[id];
        
        for (int i = 0; i < id; i++) {
            f[i] = i;
        }
        
        for (String[] e : pairs) {
            int fa = find(f, map, e[0]);
            int fb = find(f, map, e[1]);
            if (fa != fb) {
                f[fa] = fb;
            }
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!map.containsKey(words1[i])) {
                return false;
            }
            if (!map.containsKey(words2[i])) {
                return false;
            }
            int fa = find(f, map, words1[i]);
            int fb = find(f, map, words2[i]);
            if (fa != fb) {
                return false;
            }
        }

        return true;

    }
    
    private int find(int[] f, Map<String, Integer> map, String k) {
        int id = map.get(k);
        while (id != f[id]) {
            id = f[id];
        }
        return id;
    }
}
