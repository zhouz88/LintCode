import java.util.Map;
import java.util.TreeMap;

class MyCalendarThree {
    private TreeMap<Integer, Integer> map;
    
    public MyCalendarThree() {
        this.map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int sum = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            sum += e.getValue();
            max = Math.max(max, sum);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
