import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        List<Integer>[] adjList = new ArrayList[numCourses];
        int i;
        for (i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] e : prerequisites) {
            adjList[e[1]].add(e[0]);
        }
        for (i = 0; i < numCourses; i++) {
            if (hasCycle(adjList, i, visited, new boolean[numCourses])) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<Integer>[] adjList, int i, boolean[] visited, boolean[] cache) {
        if (visited[i]) {
            return false;
        }

        if (cache[i]) {
            return true;
        }
        
        cache[i] = true;
        
        for (int k:adjList[i]) {
            if (hasCycle(adjList, k, visited, cache)) {
                return true;
            }
        }
        
        visited[i] = true;

        return false;
    }
}
