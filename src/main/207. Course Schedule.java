import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(state, adjList, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int[] state, List<Integer>[] adjList, int start) {
        if (state[start] == 1) {
            return false;
        }
        if (state[start] == -1) {
            return true;
        }
        state[start] = -1;
        for (int i = 0; i < adjList[start].size(); i++) {
            if (hasCycle(state, adjList, adjList[start].get(i))) {
                return true;
            }
        }
        state[start] = 1;
        return false;
    }
}
