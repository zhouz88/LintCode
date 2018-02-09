class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }
        int cnt = n;
        for (int[] edge : edges) {
            int fa1 = find(edge[0], map);
            int fa2 = find(edge[1], map);
            if (fa1 != fa2) {
                //union;
                map[fa1] = fa2;
                cnt--;
            }
        }
        return cnt == 1;
    }
    
    private int find(int start, int[] map) {
        while (start != map[start]) {
            start = map[start];
        }
        return start;
    }
}
