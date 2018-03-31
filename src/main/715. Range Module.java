import java.util.ArrayList;
import java.util.List;

class RangeModule {

    private List<Interval> list;

    public RangeModule() {
        list = new ArrayList<>();
    }

    public void addRange(int left, int right) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        for (; i < list.size() && list.get(i).end < left; i++) {
            res.add(list.get(i));
        }
        Interval newInterval = new Interval(left, right);
        for (;i < list.size() && list.get(i).start <= newInterval.end; i++) {
            newInterval.start = Math.min(list.get(i).start, newInterval.start);
            newInterval.end = Math.max(list.get(i).end, newInterval.end);
        }
        res.add(newInterval);
        for (;i < list.size();i++) {
            res.add(list.get(i));
        }
        list = res;
    }

    public boolean queryRange(int left, int right) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (r - l)/2 + l;
            if (list.get(mid).start > right) {
                r = mid - 1;
            } else if (list.get(mid).end < left){
                l = mid + 1;
            } else {
                return list.get(mid).start <= left && list.get(mid).end >= right;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        List<Interval> res = new ArrayList<>();
        for (int i = 0;i < list.size(); i++) {
            if (list.get(i).end <= left || list.get(i).start >= right) {
                res.add(list.get(i));
            } else {
                if (list.get(i).start < left) {
                   res.add(new Interval(list.get(i).start, left));
                }
                if (list.get(i).end > right) {
                    res.add(new Interval(right, list.get(i).end));
                }
            }
        }
        list = res;
    }

    private static class Interval {
        int start;
        int end;

        public Interval(int a, int b) {
            this.start = a;
            this.end = b;
        }
    }

}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
