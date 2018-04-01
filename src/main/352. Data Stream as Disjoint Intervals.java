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
class SummaryRanges {
    List<Interval> list = new ArrayList<>();
    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {
       list = insert(new Interval(val, val));
    }

    public List<Interval> getIntervals() {
        return list;
    }

    private List<Interval> insert(Interval interval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        for (;i < list.size() && list.get(i).end < interval.start - 1; i++) {
            res.add(list.get(i));
        }
        for (;i < list.size() && list.get(i).start <= interval.end + 1; i++) {
            interval.start = Math.min(interval.start, list.get(i).start);
            interval.end = Math.max(interval.end, list.get(i).end);
        }
        res.add(interval);
        for (;i < list.size();i++){
            res.add(list.get(i));
        }
        return res;
    }

}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
