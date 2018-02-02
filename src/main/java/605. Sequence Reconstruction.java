import java.util.*;

public class Solution {
    /*
    http://www.lintcode.com/en/problem/sequence-reconstruction/
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        int total = org.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> endsMap  = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] t : seqs) {
            for (int i = 0; i < t.length - 1; i++) {
                int[] k = new int[]{t[i], t[i + 1]};
                endsMap.put(k[1], endsMap.getOrDefault(k[1], 0) + 1);
                graph.putIfAbsent(k[0], new ArrayList<>());
                graph.get(k[0]).add(k[1]);
            }
        }
        for (int[] t : seqs) {
            for (int g : t) {
                set.add(g);
            }
        }
        if (set.size() != total) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int k : org) {
            if (!endsMap.containsKey(k)) {
                q.add(k);
            }
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int u = 0; u < size; u++) {
                int node = q.poll();
                if (!graph.containsKey(node)) continue;
                for (int i = 0; i < graph.get(node).size(); i++) {
                    int tmp = graph.get(node).get(i);
                    int numbers = endsMap.get(tmp);
                    if (numbers == 1) {
                        endsMap.put(tmp, 0);
                        q.add(tmp);
                    } else if (numbers > 1) {
                        endsMap.put(tmp, numbers - 1);
                    }
                }
            }
            step++;
        }
        return step == total;
    }
}
