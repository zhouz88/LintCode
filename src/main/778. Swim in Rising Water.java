class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] f = new int[m*n];
        final int[][] directions = {{1, 0},{0, 1},{-1, 0},{0, -1}};
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               l = Math.min(l, grid[i][j]);
               r = Math.max(r, grid[i][j]);
            }
        }
        while (l <= r) {
            int k = (r + l)/2;
            int[][] G = update(grid, k);
            for (int i = 0; i < f.length; i++) {
                f[i] = i;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    for (int[] dir : directions) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x>=0&&y>=0&&x<m&&y<n&&G[x][y]==G[i][j]) {
                            int fa = find(f, i * n + j);
                            int fb = find(f, x * n + y);
                            if (fa != fb) {
                                f[fb] = fa;
                            }
                        }
                    }
                }
            }
            int fa = find(f, 0);
            int fb = find(f, (m - 1) * n  + n - 1);
            if (fa == fb) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return l;
    }

    private int find(int[] f, int i) {
        if (i == f[i]) {
            return i;
        }
        return f[i] = find(f, f[i]);
    }

    private int[][] update(int[][] grid, int k) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                copy[i][j] = Math.max(k, grid[i][j]);
            }
        }
        return copy;
    }
}
