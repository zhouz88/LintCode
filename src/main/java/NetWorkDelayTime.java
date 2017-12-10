/*
743. Network Delay Time My SubmissionsBack to Contest
User Accepted: 518
User Tried: 839
Total Accepted: 531
Total Submissions: 2331
Difficulty: Medium
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
*/
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N+1][N+1];
        for (int[] k : graph) {
            Arrays.fill(k, -1);
        }
        for (int[] t : times) {
            graph[t[0]][t[1]] = t[2];
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[K] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int u = 0; u < size; u++) {
                int node = q.poll();
                for (int i = 1; i <= N; i++) {
                    if (graph[node][i] >= 0) {
                        if (distance[i] == -1) {
                            distance[i] = distance[node] + graph[node][i];
                            q.add(i);
                        } else if (distance[i] > distance[node] + graph[node][i]){
                            distance[i] = distance[node] + graph[node][i];
                            q.add(i);
                        }
                    }
                }
            }
        }
        Arrays.sort(distance);
        if (distance[1] == -1) {
            return -1;
        }
        return distance[distance.length - 1] <= 0 ? -1: distance[distance.length - 1];
    }
}
