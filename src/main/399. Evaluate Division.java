import java.util.*;

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int idx = 0;
        Map<String, Integer> map = new HashMap<>();//used for mapping strings to distinct numbmer;
        for (String[] k : equations) {
            if (!map.containsKey(k[0])) {
                map.put(k[0], idx++);
            }
            if (!map.containsKey(k[1])) {
                map.put(k[1], idx++);
            }
        }
        Double[][] graph = new Double[idx][idx];
        idx = 0;
        for (String[] k : equations) {
            int first = map.get(k[0]);
            int second = map.get(k[1]);
            graph[first][second] = values[idx];
            if (values[idx] == 0) continue;
            graph[second][first] = 1.0 / values[idx];
            idx++;
        }
        double[] res = new double[queries.length];
        for (idx = 0; idx < queries.length; idx++) {
            res[idx] = bfs(graph, queries[idx], map);
        }
        return res;
    }

    private double bfs(Double[][] graph, String[] query, Map<String, Integer> map) {
        if (!map.containsKey(query[1]) || !map.containsKey(query[0])) {
            return -1.0;
        }
        
        int end = map.get(query[1]);
        int start = map.get(query[0]);
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Double> doubleValues = new LinkedList<>();
        q.add(start);
        doubleValues.add(1.0);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                double value = doubleValues.poll();
                if (end == node) {
                    return value;
                }
                for (int j = 0; j < graph[node].length; j++) {
                    if (graph[node][j] != null && !visited.contains(j)) {
                        double newValue = graph[node][j] * value;
                        q.add(j);
                        doubleValues.add(newValue);
                        visited.add(j);
                    }
                }
            }
        }
        return -1.0;
    }
}
