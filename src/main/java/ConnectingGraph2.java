public class ConnectingGraph2 {
    /*
    * @param n: An integer
    590. Connecting Graph II 

 Description
 Notes
 Testcase
 Judge
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(a), Returns the number of connected component nodes which include node a.

Have you met this question in a real interview? Yes
Example
5 // n = 5
query(1) return 1
connect(1, 2)
query(1) return 2
connect(2, 4)
query(1) return 3
connect(1, 4)
query(1) return 3
    */
    private int[] map;
    private int[] counts;
    
    public ConnectingGraph2(int n) {
        // do intialization if necessary
        map = new int[n + 1];
        counts = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = i;
            counts[i] = 1;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int A = find(map, a);
        int B = find(map, b);
        if (A != B) {
            map[A] = B;
            counts[B] += counts[A];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int t = find(map, a);
        return counts[t];
    }
    
    private int find(int[] map, int start) {
        int parent = start;
        while (parent != map[parent]) {
            parent = map[parent];
        }
        while (start != map[start]) {
            int tmp = map[start];
            map[start] = parent;
            start = tmp;
        }
        return parent;
    }
}
