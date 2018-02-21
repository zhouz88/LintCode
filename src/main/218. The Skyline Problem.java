import java.util.*;

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<>();
        PriorityQueue<Line> pq = new PriorityQueue<>();

        for (int[] building : buildings) {
            pq.add(new Line(building[0], - building[2]));
            pq.add(new Line(building[1], building[2]));
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int pre = 0;
        while (!pq.isEmpty()) {
            Line line = pq.poll();
            if (line.isStart < 0) {
                map.put(-line.isStart, map.getOrDefault(-line.isStart,0) + 1);
            } else {
                map.put(line.isStart, map.get(line.isStart) - 1);
                if (map.get(line.isStart) == 0) {
                    map.remove(line.isStart);
                }
            }
            
            int max = map.descendingKeySet().iterator().next();
            if (max != pre) {
                ret.add(new int[]{line.val, max});
            }
            pre = max;
        }
        return ret;
    }

    private static class Line implements Comparable<Line>{
        int val;
        int isStart;
        public Line(int val, int isStart){
            this.val = val;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(val, o.val) == 0 ? 
                Integer.compare(isStart, o.isStart):Integer.compare(val, o.val);
        }
    }
}
