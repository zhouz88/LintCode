import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num :nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue()) == 0 ?
                        Integer.compare(o2.getKey(), o1.getKey()) : Integer.compare(o1.getValue(), o2.getValue()) ;
            }
        });
        int i  =0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (i < k) {
                pq.add(e);
            } else {
                if (pq.peek().getValue() >= e.getValue()) {
                    continue;
                } else {
                    pq.poll();
                    pq.add(e);
                }
            }
            i++;
        }
        int len = Math.min(k, pq.size());
        Integer[] res = new Integer[len];
        i = len - 1;
        while (!pq.isEmpty()) {
            res[i--] = pq.poll().getKey();
        }
        return Arrays.asList(res);
    }
}
