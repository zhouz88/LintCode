import java.util.ArrayList;
import java.util.List;

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        for (;i < intervals.size() && intervals.get(i).end < newInterval.start; i++) {
            res.add(intervals.get(i));
        }
        for (;i < intervals.size() && intervals.get(i).start <= newInterval.end; i++) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
        }
        res.add(newInterval);
        for (;i < intervals.size(); i++) {
            res.add(intervals.get(i));
        }
        return res;
    }

//      public class Interval {
//         int start;
//         int end;
//         Interval() { start = 0; end = 0; }
//         Interval(int s, int e) { start = s; end = e; }
//     }
}
