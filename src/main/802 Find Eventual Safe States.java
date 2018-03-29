import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] hasCycle = new int[graph.length];
        // -1 cycle 0 not visite 1 no cycle;
        for (int i = 0; i < graph.length; i++) {
            if (!hasCycle(i, graph, hasCycle)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean hasCycle(int start, int[][] graph, int[] hasCycle) {
        if (hasCycle[start] == 1) {
            return false;
        }
        if (hasCycle[start] == -1) {
            return true;
        }
        hasCycle[start] = -1;
        for (int i = 0; i < graph[start].length; i++) {
            if (hasCycle(graph[start][i], graph, hasCycle)) {
                return true;
            }
        }
        hasCycle[start] = 1;
        return false;
    }
}
