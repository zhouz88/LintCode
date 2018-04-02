class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = new int[]{-1, -1};
        int[] can2 = new int[]{-1, -1};
        int n = edges.length;
        int[] f = new int[n + 1];
        for (int[] e : edges) {
            if (f[e[1]] == 0) {
                f[e[1]] = e[0];
            } else {
                can1 = new int[]{f[e[1]], e[1]};
                can2 = new int[]{e[0], e[1]};
                e[1] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int[] e : edges) {
            if (e[1] == 0) {
                continue;
            }
            int fa = find(f, e[0]);
            if (fa == e[1]) {
                if (can1[0] == -1) {
                    return e;
                }
                return can1;
            }
            f[e[1]] = fa;
        }
        return can2;
    }

    private int find(int[] f, int i) {
        if (i == f[i]) {
            return i;
        }
        return f[i] = find(f, f[i]);
    }
}
