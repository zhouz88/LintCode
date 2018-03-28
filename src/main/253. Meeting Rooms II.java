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

//PrioityQueue
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

//Sort & Two Pointers
import java.util.*;

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
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int sum = 0, ans = 0;
        for (int i = 0, j = 0; i < starts.length;){
            if (starts[i] < ends[j]) {
                sum++;
                i++;
                ans = Math.max(ans, sum);
            } else {
                sum--;
                j++;
            }
        }
        return ans;
    }
}

//TreeMap

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval interval: intervals) {
            map.put(interval.start, map.getOrDefault(interval.start,0)+ 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int sum = 0, ans = 0;
        for (Map.Entry<Integer, Integer> e :map.entrySet()) {
            sum += e.getValue();
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
