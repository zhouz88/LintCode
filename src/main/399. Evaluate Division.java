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
