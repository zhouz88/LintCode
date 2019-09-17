import java.util.*;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> c : connections) {
            map.putIfAbsent(c.get(0), new ArrayList<>());
            map.get(c.get(0)).add(c.get(1));
            map.putIfAbsent(c.get(1), new ArrayList<>());
            map.get(c.get(1)).add(c.get(0));
        }
        dfsNext(0, map, new boolean[n], result, new int[n], new int[n], -1);
        return result;
    }

    private int id = 0;

    private boolean dfsNext(int start, Map<Integer, List<Integer>> map, boolean[] visited, List<List<Integer>> result
    , int[] nodeIds, int[] minLevel, int parent) {
        if (visited[start]) {
            return false;
        }
        visited[start] = true;
        nodeIds[start] = id;
        minLevel[start] = id;
        id++;
        List<Integer> list = map.get(start);
        for (int next : list) {
            if (dfsNext(next, map, visited, result, nodeIds, minLevel, start)) {
                minLevel[start] = Math.min(minLevel[start], minLevel[next]);
                if (minLevel[next] > nodeIds[start]) {
                    result.add(Arrays.asList(start, next));
                }
            } else if (next != parent) {
                minLevel[start] = Math.min(nodeIds[next], minLevel[start]);
            }
        }
        return true;
    }
}
