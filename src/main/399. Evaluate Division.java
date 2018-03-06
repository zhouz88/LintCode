import java.util.*;

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Double> valueMap = new HashMap<>();
        int i;
        for (i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            String first = equation[0] + " " + equation[1];
            String second = equation[1] + " " + equation[0];
            double firstValue = values[i];
            double secondValue = 1.0/values[i];

            map.putIfAbsent(equation[0], new HashSet<>());
            map.putIfAbsent(equation[1],new HashSet<>());
            map.get(equation[0]).add(equation[1]);
            map.get(equation[1]).add(equation[0]);

            valueMap.put(first, firstValue);
            valueMap.put(second, secondValue);
        }
        
        double[] ret = new double[queries.length];
        
        for (i = 0; i < queries.length; i++) {
            ret[i] = bfs(queries[i][0], queries[i][1], map, valueMap);
        }
        
        return ret;
    }

    private double bfs(String start, String end, Map<String, Set<String>> map, Map<String, Double> valueMap) {
        Queue<String> q = new LinkedList<>();
        Queue<Double> values = new LinkedList<>();
        
        if (!map.containsKey(start) || !map.containsKey(end)) {
            return -1;
        }
        q.add(start);
        values.add(1D);
        Set<String> set = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                double tmp = values.poll();
                if (node.equals(end)) {
                    return tmp;
                }
                for (String k : map.get(node)) {
                    if (!set.contains(k)) {
                        set.add(k);
                        q.add(k);
                        double to = valueMap.get(node + " " + k);
                        values.add(to*tmp);
                    }
                }
                
            }
        }
        return -1.0;
    }
}

//new version
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
