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


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Line> pq = new PriorityQueue<>();
        for (int[] building: buildings) {
            pq.add(new Line(building[0], -1, building[2]));
            pq.add(new Line(building[1], 1, building[2]));
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int preMax = 0;
        while (!pq.isEmpty()) {
            Line node = pq.poll();
            if (node.isStart == -1) {
                map.put(node.height, map.getOrDefault(node.height, 0) + 1);
            } else {
                map.put(node.height, map.get(node.height) - 1);
                if (map.get(node.height) == 0) {
                    map.remove(node.height);
                }
            }
            int maxHeight = map.descendingKeySet().iterator().next();
            if (maxHeight != preMax) {
                res.add(new int[]{node.val, maxHeight});
                preMax = maxHeight;
            }
        }
        return res;
    }

    private static class Line implements Comparable<Line>{
        int val;
        int isStart;
        int height;
        public Line(int val, int isStart, int height) {
            this.val = val;
            this.isStart = isStart;
            this.height = height;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.val, o.val) == 0 ?
                    Integer.compare(this.isStart * this.height, o.isStart * o.height)
                    : Integer.compare(this.val, o.val);

        }
    }
}

