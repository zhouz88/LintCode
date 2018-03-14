import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        for (int[] k : rectangles) {
            maxX = Math.max(Math.max(k[0], k[2]) , maxX);
            maxY = Math.max(Math.max(k[1], k[3]) , maxY);
            minX = Math.min(Math.min(k[0], k[2]) , minX);
            minY = Math.min(Math.min(k[1], k[3]) , minY);
            String point1 = k[0] + " " + k[1];
            String point2 = k[2] + " " + k[3];
            String point3 = k[0] + " " + k[3];
            String point4 = k[2] + " " + k[1];
            sum += Math.abs(k[2] - k[0]) * Math.abs(k[3] - k[1]);
            map.put(point1, map.getOrDefault(point1, 0) + 1);
            map.put(point2, map.getOrDefault(point2, 0) + 1);
            map.put(point3, map.getOrDefault(point3, 0) + 1);
            map.put(point4, map.getOrDefault(point4, 0) + 1);
        }
        int area = (maxX - minX) * (maxY - minY);
        if (sum != area) {
            return false;
        }
        String l = minX + " " + minY;
        String r = minX + " " + maxY;
        String L = maxX + " " + minY;
        String R = maxX + " " + maxY;
        if (!map.containsKey(l) || !map.containsKey(r) || !map.containsKey(L) || !map.containsKey(R)) {
            return false;
        }
        if (map.get(l) != 1 || map.get(r) != 1  || map.get(L) != 1  || map.get(R) != 1 ) {
            return false;
        }
        map.remove(l);
        map.remove(r);
        map.remove(L);
        map.remove(R);
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue()% 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
