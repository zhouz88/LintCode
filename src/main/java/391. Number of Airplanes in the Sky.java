import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

public class Solution {
    /*
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;//corner case
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (Interval k : airplanes) {
            pq.add(new Node(k.start, 0));
            pq.add(new Node(k.end, 1));
        }
        int cnt = 0;
        int max = -1;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.state == 0) {
                cnt++;
            } else {
                cnt--;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    private static class Node implements Comparable<Node>{
        public int x;
        public int state;

        public Node(int x, int state) {
            this.x = x;
            this.state = state;
        }

        public int compareTo(Node o) {
            if (this.x == o.x) {
                return o.state - this.state;
            } else {
                return this.x - o.x;
            }
        }
    }
}
