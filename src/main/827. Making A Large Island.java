import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] f = new int[n * n];
        int[] counts = new int[n * n];
        Arrays.fill(f, -1);
        Arrays.fill(counts, -1);

        int[][] DIRECTIONS = {{-1, 0},{0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    f[i * n + j] = i * n + j;
                    counts[i * n + j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int[] dir : DIRECTIONS) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    if (x>=0&&y>=0&&x<m&&y<n&&grid[x][y]==1) {
                        int t = x * n + y;
                        int fa = find(f, t);
                        if (fa != i * n + j) {
                            f[fa] = i * n + j;
                            counts[i * n + j] += counts[fa];
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int k : counts) max = Math.max(max, k);
        int[][] DIRECTIONS1 = {{-1, 0},{0, -1},{1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    f[i * n + j] = i * n + j;
                    counts[i * n + j] = 1;
                    List<Integer> list = new ArrayList<>();
                    for (int[] dir : DIRECTIONS1) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                            int t = x * n + y;
                            int fa = find2(f, t);
                            if (fa != i * n + j) {
                                list.add(fa);
                                f[fa] = i * n + j;
                                counts[i * n + j] += counts[fa];
                            }
                        }
                    }
                    for (int g : list) f[g] = g;
                    max = Math.max(counts[i *n + j], max);
                    counts[i *n + j] = -1;
                    f[i * n + j] = -1;
                }
            }
        }
        return max;
    }

    private int find(int[] f, int t) {
        if (f[t] == t) {
            return t;
        }
        return f[t] = find(f, f[t]);
    }

    private int find2(int[] f, int t) {
        if (f[t] == t) {
            return t;
        }
        return find2(f, f[t]);
    }
}
