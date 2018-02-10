import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param rating: the rating of the movies
     * @param G: the realtionship of movies
     * @param S: the begin movie
     * @param K: top K rating
     * @return: the top k largest rating moive which contact with S
     */
    public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        // Write your code here
        int n = rating.length;
        int[] map = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = i;
        }
        int i = 0;

        for (int[] g : G) {
            int a = find(i, map);
            if (g.length == 0 || g == null) continue;
            
            for (int k : g) {
                int b = find(k, map);
                if (a != b) {
                    map[b] = a;
                }
            }
            
            i++;
        }

        int father = find(S, map);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (i = 0; i < rating.length; i++) {
            if (i == S) continue;
            if (father == find(i, map)) {
                if (pq.size() < K) {
                    pq.add(new Node(i, rating[i]));
                } else {
                    if (rating[i] <= pq.peek().val) {
                        continue;
                    } else {
                        pq.poll();
                        pq.add(new Node(i, rating[i]));
                    }
                }
            }
        }
        int size = Math.min(K, pq.size());
        int[] ret = new int[size];
        i = 0;
        while (!pq.isEmpty()) {
            ret[i++] = pq.poll().id;
        }
        return ret;
    }

    public int find(int i, int[] map) {
        int start = i;
        while (start != map[start]) {
            start = map[start];
        }
        return start;
    }

    private static class Node implements Comparable<Node>{
        int val;
        int id;
        public Node(int i, int j) {
            this.id  = i;
            this.val = j;
        }

        @Override
        public int compareTo(Node o) {
            return val == o.val ? o.id - id: val - o.val;
        }
    }
}
