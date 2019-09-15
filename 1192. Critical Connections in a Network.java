import java.util.*;

class Solution {
    private int id;
    private int[] mins;
    private int[] ids;
    private int[] parents;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        this.mins = new int[n];
        this.ids = new int[n];
        this.parents = new int[n];

        for (List<Integer> connection : connections) {
            graph.putIfAbsent(connection.get(0), new ArrayList<>());
            graph.get(connection.get(0)).add(connection.get(1));
            graph.putIfAbsent(connection.get(1), new ArrayList<>());
            graph.get(connection.get(1)).add(connection.get(0));
        }

        dfs(0,graph, result, new boolean[n]);
        return result;
    }

    private void dfs(int start, Map<Integer, List<Integer>> graph, List<List<Integer>> res, boolean[] visited) {
        if (visited[start]) {
            return;
        }
        ids[start] = id;
        mins[start] = id++;
        visited[start] = true;
        List<Integer> list = graph.get(start);
        for (int next : list) {
            if (!visited[next]) {
                parents[next] = start;
                dfs(next, graph, res, visited);
                mins[start] = Math.min(mins[start], mins[next]);
                if (mins[next] > ids[start]) {
                    res.add(Arrays.asList(start, next));
                }
            } else if (next != parents[start]){
                mins[start] = Math.min(mins[start], ids[next]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().criticalConnections(4, Arrays.asList(Arrays.asList( 0, 1), Arrays.asList( 1, 2),
                Arrays.asList( 2, 3),
                Arrays.asList( 2, 0))));
    }
}
