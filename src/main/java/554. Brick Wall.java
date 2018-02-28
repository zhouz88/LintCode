import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();       
        int i, j;
        int max = 0;
        for (i = 0; i < wall.size(); i++) {
            List<Integer> list = wall.get(i);
            int sum = 0;
            for (j = 0; j < list.size() - 1; j++) {
                sum += list.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        }
        if (max == 0) return wall.size();
        return wall.size() - max;
    }
}
