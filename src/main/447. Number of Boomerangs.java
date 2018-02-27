import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
         Map<Integer, Integer> countsMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                countsMap.put(distance, countsMap.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> e : countsMap.entrySet()) {
                sum += (e.getValue() - 1) * (e.getValue());
            }
            countsMap.clear();
        }
        return sum;
    }

    private int getDistance(int[] a, int[] b) {
        int A = (a[0] - b[0]);
        int B = (a[1] - b[1]);
        return A * A + B * B;
    }
}
