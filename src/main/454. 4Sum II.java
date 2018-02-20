import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> count1Map = new HashMap<>();
        
        for (int k : A) {
            for (int t : B) {
                count1Map.put(k + t, count1Map.getOrDefault(k + t, 0) + 1);
            }
        }
         
        int cnt = 0;
        for (int k : C) {
            for (int t : D) {
                if (!count1Map.containsKey(-k-t)) continue;
                cnt += count1Map.get(-k-t);
            }
        }
        
        return cnt;
    }
}
