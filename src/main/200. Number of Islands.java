//dfs
class Solution {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r >= 0 && c >= 0 && r < nr && c < nc && grid[r][c] == '1') {
            grid[r][c] = '?';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }
        return num_islands;
    }
}
//UNION FIND
class Solution {
    public int numIslands(char[][] grid) {

        //corner case return 0 or throw Exception() ?? 
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;

        int i, j;
        int cnt = 0;
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++)
                if (grid[i][j] == '1')
                    cnt++;

        //make sets;
        int[] map = new int[m*n];
        for (i = 0; i < map.length; i++) {
            map[i] = i;
        }

        final int[][] directions = {{1, 0},{0, 1}};

        //union find
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int fa = find(i*n + j, map);

                    for (int[] dir : directions) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;

                        if(x<0||y<0||x>=m||y>=n||grid[x][y] =='0') continue;

                        int tmp = find(n*x+y, map);

                        if (tmp != fa) {
                            map[tmp] = fa;//union
                            cnt--;
                        }
                    }
                }

            }
        }

        return cnt;
    }

    private int find(int start, int[] map) {
        if (map[start] == start) {
            return start;
        }
        return map[start] = find(map[start], map);
    }
}




import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int m, int n, Point[] operators) {
        // write your code here
        List<Integer> ret = new ArrayList<>();
        if (operators == null) {
            return ret;
        }
        int[] map = new int[m * n];
        for (int i = 0; i < map.length; i++) {
            map[i] = i;
        }
        int[][] grid = new int[m][n];

        int cnt = 0;
        final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < operators.length; i++) {
            Point tmp = operators[i];
            if (grid[tmp.x][tmp.y] == 0) cnt++;
            grid[tmp.x][tmp.y] = 1;
            for (int[] dir : directions) {
                int x = dir[0] + tmp.x;
                int y = dir[1] + tmp.y;
                if (x < 0 || y < 0 || x >= m || y >= n||grid[x][y]==0) {
                    continue;
                }
                int fa = find(x * n + y, map);
                if (fa != tmp.x * n + tmp.y) {//uion
                    map[fa] = tmp.x * n + tmp.y;
                    cnt--;
                }
            }
            ret.add(cnt);
        }
        return ret;
    }
        
    private int find(int start, int[] map) {
            while (start != map[start]) {
                start = map[start];
            }
            return start;
    }
}
