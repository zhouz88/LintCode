import java.util.*;

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<GraphNode>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] str = equations[i];
            map.putIfAbsent(str[0], new ArrayList<>());
            map.putIfAbsent(str[1], new ArrayList<>());
            map.get(str[0]).add(new GraphNode(str[1], values[i]));
            map.get(str[1]).add(new GraphNode(str[0], 1.0/values[i]));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = bfs(map, queries[i][0], queries[i][1]);
        }
        return res;
    }

    private double bfs(Map<String, List<GraphNode>> map, String start, String end) {
        if (!map.containsKey(start)) { //bug 1
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        Queue<Double> values = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(start);
        values.add(1.0);
        visited.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                String node = q.poll();
                double value = values.poll();
                if (node.equals(end)) {
                    return value;
                }
                if (map.get(node) == null) continue; //bug2 
                for (int i = 0; i < map.get(node).size(); i++) {
                    GraphNode next = map.get(node).get(i);
                    if (!visited.contains(next.cur)) {
                        q.add(next.cur);
                        values.add(value * next.val);
                        visited.add(next.cur); //bug3
                    }
                }
            }
        }
        return -1;
    }

    private static class GraphNode {
        String cur;
        double val;
        public GraphNode(String name, double b) {
            this.cur = name;
            this.val = b;
        }
    }
}
