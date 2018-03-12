class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) {
                q.add(i);
            }
        }
        while (set.size() > 2) {
            Queue<Integer> next = new LinkedList<>();
            while (!q.isEmpty()){
                int i = q.poll();
                int tmp = graph[i].iterator().next();
                graph[i].remove(tmp);
                graph[tmp].remove(i);
                set.remove(i);
                if (graph[tmp].size() == 1) {
                    next.add(tmp);
                }
            }
            q = next;
        }
        return new ArrayList<>(set);
    }
}
