import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        int ans = 0;
        for (int i = 0; i < positions.length; i++) {
            int start = positions[i][0];
            int end = positions[i][0] + positions[i][1];
            Integer rangeStart = map.floorEntry(start).getKey();
            Integer rangeEnd = map.ceilingKey(end);
            int max = map.floorEntry(start).getValue();
            while (rangeStart != null && rangeStart < end) {
                max = Math.max(max, map.get(rangeStart));
                rangeStart = map.higherKey(rangeStart);
            }
            int total = max + positions[i][1];
            ans  = Math.max(total, ans);
            res.add(ans);
            int tail = map.floorEntry(end).getValue();
            map.put(start, total);
            map.put(end, tail);
            Integer r = map.higherKey(start);
            while (r != null && r < end) {
                map.remove(r);
                r = map.higherKey(r);
            }

        }
        return res;
    }
}
