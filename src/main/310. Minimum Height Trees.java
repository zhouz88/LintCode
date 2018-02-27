import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new HashSet<>());
            graph.get(e[0]).add(e[1]);
            graph.putIfAbsent(e[1], new HashSet<>());
            graph.get(e[1]).add(e[0]);
        }
        
        for (int i = 0; i < n; i++) {
            res.add(i);
        }
        
        while (res.size() > 2) {
            
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, HashSet<Integer>> e : graph.entrySet()) {
                if (e.getValue().size() == 1) {
                    list.add(new int[]{e.getKey(), e.getValue().iterator().next()});
                }
            }
            
            for (int[] k : list) {
                graph.get(k[0]).remove(k[1]);
                graph.remove(k[0]);
                graph.get(k[1]).remove(k[0]);
            }


            if (graph.size() <= 2) {
                res.clear();
                res.addAll(graph.keySet());
                break;
            }

        }

        return res;
    }
}
