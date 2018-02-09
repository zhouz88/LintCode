import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Line> pq = new PriorityQueue<>();
        for (Interval interval : intervals) {
            pq.add(new Line(interval.start, -1));
            pq.add(new Line(interval.end, 1));
        }
        int total = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            Line tmp = pq.poll();
            if (tmp.state == -1) {
                total++;
            } else {
                total--;
            }
            max = Math.max(max, total);
        }
        return max;
    }
    
    private static class Line implements Comparable<Line>{
        int val;
        int state;
        public Line(int val, int state) {
            this.val = val;
            this.state = state;
        }

        @Override
        public int compareTo(Line o2) {
            int end = Integer.compare(o2.state, state);
            return Integer.compare(val, o2.val) == 0 ? end : Integer.compare(this.val, o2.val);
        }
    }
}
