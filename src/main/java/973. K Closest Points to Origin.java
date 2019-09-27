import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Long.compare(getDis(o2), getDis(o1));
            }
        });
        for (int i = 0; i < points.length; i++) {
            if (i < K) {
                pq.add(points[i]);
            } else {
                if (getDis(points[i]) < getDis(pq.peek())) {
                    pq.poll();
                    pq.add(points[i]);
                }
            }
        }
        int[][] ret = new int[pq.size()][2];
        return pq.toArray(ret);
    }

    private long getDis(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
