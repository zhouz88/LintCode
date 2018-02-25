import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for (int[] k :prerequisites) {
            adjList[k[1]].add(k[0]);
            indegree[k[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;  i< numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        int cnt  = 0;
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            list.add(node);
            for (int i =0 ; i < adjList[node].size(); i++) {
                indegree[adjList[node].get(i)]--;
                if (indegree[adjList[node].get(i)] == 0){
                    q.add(adjList[node].get(i));
                }
            }
        }
        if (list.size() != numCourses) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        for (int k : list) {
            res[idx++] = k;
        }
        return res;
    }
}
