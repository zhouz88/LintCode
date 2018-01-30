import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    /*
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if (k == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<>();

        for (String word:words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Point[] points = new Point[map.size()];
        int idx = -1;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            points[++idx] = new Point(e.getKey(), e.getValue());
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for (int i= 0; i < points.length; i++) {
            if (i <= k - 1) {
                pq.add(points[i]);
            } else {
                if (points[i].val < pq.peek().val) {
                    continue;
                } else {
                    pq.add(points[i]);
                    pq.poll();
                }
            }
        }
        
        String[] ret = new String[k];
        
        for (int i = 0; i < k; i++) {
            ret[k - i - 1] = pq.poll().str;
        }
        return ret;
    }


    private static class Point implements Comparable<Point> {
        String str;
        int val;

        public Point(String x, int y ) {
            str = x;
            val = y;
        }
        @Override
        public int compareTo(Point o) {
            if (this.val == o.val) {
                return o.str.compareTo(this.str);
            }
            return this.val - o.val;
        }
    }
}




