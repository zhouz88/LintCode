import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }

        int y = Integer.MAX_VALUE;
        int Y = Integer.MIN_VALUE;
        int x = Integer.MAX_VALUE;
        int X = Integer.MIN_VALUE;

        for (Point point: points) {
            y = Math.min(point.y, y);
            Y = Math.max(point.y, Y);
            x = Math.min(point.x, x);
            X = Math.max(point.x, X);
        }
        int n = Y - y + 1;
        int m = X - x + 1;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (Point point: points) {
            int i = point.x - x;
            int j = point.y - y;
            map.put(i*n+j, map.getOrDefault(i*n+j, 0)+ 1);
        }
        int max = 0;
        for (int k : map.keySet()) {
            max = Math.max(max, map.get(k));
        }
        list.addAll(map.keySet());
        for (int i = 0; i < list.size(); i++) {
            int I = list.get(i);
            x = I/n;
            y = I%n;
            for (int j = i + 1; j < list.size(); j++) {
                int J = list.get(j);
                X = J/n;
                Y = J%n;
                int cnt = map.get(I) + map.get(J);
                for (int k = j + 1; k < list.size(); k++) {
                        int u = list.get(k)/n;
                        int v = list.get(k)%n;
                        if (ok(x,y,X,Y,u,v)) {
                            cnt += map.get(list.get(k));
                        }
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }

    private boolean ok(long x, long y, long x1, long y1, long u, long v) {
        return (v - y)*(x1 - x) == (y1 - y)*(u - x);
    }
}
