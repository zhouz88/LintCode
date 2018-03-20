import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] hasCycle = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            if (dfs(i, visited, graph, hasCycle)) {
                res.add(i);
            } else {
                hasCycle[i] = -1;
            }
            visited[i] = false;
        }
        Collections.sort(res);
        return res;
    }

    private boolean dfs(int start, boolean[] visited, int[][] graph, int[] hasCycle) {
        if (graph[start].length == 0) {
            return true;
        }

        if (hasCycle[start] == -1) {
            return false;
        }

        if (hasCycle[start] == 1) {
            return true;
        }
        

        for (int i = 0; i < graph[start].length; i++) {
            if (visited[graph[start][i]]) {
                hasCycle[graph[start][i]] = -1;
                return false;
            }
            visited[graph[start][i]] = true;
            if (!dfs(graph[start][i], visited, graph, hasCycle)) {
                hasCycle[start] = -1;
                return false;
            }
            visited[graph[start][i]] = false;
        }
        hasCycle[start] = 1;
        return true;
    }
}
