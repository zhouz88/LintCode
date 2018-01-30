import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /*
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        int[] idx = new int[arrays.length];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int i;
        int len = 0;
        for (i = 0; i < arrays.length; i++) {
            len += arrays[i].length;
            if (arrays[i].length != 0) pq.add(new Point(i, arrays[i][0]));
        }
        int[] res = new int[len];
        int Idx = 0;
        while (!pq.isEmpty()) {
            Point tmp = pq.poll();
            res[Idx++] = tmp.val;
            if (idx[tmp.id] + 1 < arrays[tmp.id].length) {
                idx[tmp.id]++;
                pq.add(new Point(tmp.id, arrays[tmp.id][idx[tmp.id]]));
            }
        }
        return res;
    }
    
    private static class Point implements Comparable<Point> {
        int id, val;
        
        public Point(int x, int y ) {
            id = x;
            val = y;
        }
        @Override
        public int compareTo(Point o) {
            if (o.val == this.val) {
                return this.id - o.id;
            }
            return this.val - o.val;
        }
    }
}
