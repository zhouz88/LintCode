import java.util.*;
//https://leetcode.com/problems/the-skyline-problem/description/
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(10, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] == 0) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int[] k : buildings) {
            pq.add(new int[]{k[0], -k[2]});
            pq.add(new int[]{k[1], k[2]});
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int pre = 0;
        List<int[]> ret = new LinkedList<int[]>();

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (node[1] < 0) {
                map.put(-node[1], map.getOrDefault(-node[1], 0) + 1);
            } else {
                map.put(node[1], map.get(node[1]) - 1);
                if (map.get(node[1]) == 0) {
                    map.remove(node[1]);
                }
            }

            int cur = map.lastKey();
            if (cur != pre) {
                pre = cur;
                ret.add(new int[]{node[0], cur});
            }
        }

        return ret;
    }
}
