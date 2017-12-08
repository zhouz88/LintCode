/*
589. Connecting Graph 

 Description
 Notes
 Testcase
 Judge
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, check if two nodes are connected

Have you met this question in a real interview? Yes
Example
5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true
*/
public class ConnectingGraph {
    private int[] map;
    public ConnectingGraph(int n) {
        this.map = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = i;
        }
    }
    
    public void connect(int a, int b) {
        int A = find(map, a);
        int B = find(map, b);
        if (A != B) {
            map[A] = map[B];
        }
    }
    
    public boolean query(int a, int b) {
        return find(map, a) == find(map, b);
    }
    
    private int find(int[] map, int start) {
        while (start != map[start]) {
            start = map[start];
        }
        return start;
    }
}
