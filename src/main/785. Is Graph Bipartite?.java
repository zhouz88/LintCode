import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] level = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (level[i] != 0) continue;
            q.add(i);
            level[i] = -1;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int k : graph[node]) {
                    if (level[k] == 0) {
                        q.add(k);
                        level[k] = 1 - level[node];
                    } else {
                        if (level[k] == level[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
