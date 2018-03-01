class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int[] e : edges) {
            int fa = find(f, e[0]);
            int fb = find(f, e[1]);
            if (fa == fb) {
                return e;
            } else {
                f[fa] = fb;
            }
        }
        throw new RuntimeException("good");
    }

    private int find(int[] f, int i) {
        if (f[i] == i) {
            return i;
        }
        return f[i] = find(f, f[i]);
    }
}
