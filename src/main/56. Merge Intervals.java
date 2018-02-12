import java.util.*;

/**
 * Definition for an interval.
  public class Interval {
      int start;
      int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        
        if (intervals.size() == 0) {
            return intervals;
        }
        List<Interval> ret = new ArrayList<>();
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= pre.end) {//wrong 1
                pre = new Interval(pre.start, Math.max(pre.end, intervals.get(i).end));
            } else {
                ret.add(pre);
                pre = intervals.get(i);
            }
        }
        ret.add(pre);
        return ret;
        
    }
    
}
