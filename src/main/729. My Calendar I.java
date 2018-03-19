import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    List<Line> list;

    public MyCalendar() {
        this.list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
         int l = 0, r = list.size() - 1;
         Line target1 = new Line(start, - 1);
         Line target2 = new Line(end, 1);
         
         while (l <= r) {
             int mid = ((r - l) >> 1) + l;
             if (list.get(mid).compareTo(target1) == 0) {
                 return false;
             } else if (list.get(mid).compareTo(target1) > 0) {
                 r = mid - 1;
             } else {
                 l = mid  + 1;
             }
         }
         
         if (r >= 0 && list.get(r).isStart == -1) {
             return false;
         }
         
         if (l != list.size() && list.get(l).compareTo(target2) <= 0) {
             return false;
         } 
         
         list.add(l, target2);
         list.add(l, target1);
         
         return true;
    }

    class Line implements Comparable<Line>{
        int val;
        int isStart;
        public Line(int val, int isStart) {
            this.val = val;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.val, o.val) == 0 ? Integer.compare(o.isStart, this.isStart)
                    : Integer.compare(this.val, o.val);
        }
    }
}

import java.util.Map;
import java.util.TreeMap;

class MyCalendar{
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Integer floor = map.floorKey(start);
        if (floor != null && map.get(floor) - 1 == 0) {
            return false;
        }
        if (map.subMap(start, false, end, false).size() != 0) {
            return false;
        }
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        if (map.get(start) == 0) map.remove(start);
        if (map.get(end) == 0)map.remove(end);
        return true;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
import java.util.Map;
import java.util.TreeMap;

class MyCalendar{
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Integer floor = map.floorKey(start);
        if (floor != null && map.get(floor) - 1 == 0) {
            return false;
        }
        Integer lower = map.lowerKey(end);
        if (lower != null && lower > start) {
            return false;
        }
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        if (map.get(start) == 0) map.remove(start);
        if (map.get(end) == 0)map.remove(end);
        return true;
    }
}
