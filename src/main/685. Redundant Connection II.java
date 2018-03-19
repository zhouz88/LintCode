class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] f = new int[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            if (f[edges[i][1]] == 0) {
                f[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {f[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }

        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (find(f, father) == child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            f[child] = father;
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
