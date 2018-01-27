import java.util.*;
/*

http://www.lintcode.com/en/problem/minimum-risk-path/
*/
public class Solution {
    /**
     * @param n: maximum index of position.
     * @param m: the number of undirected edges.
     * @param x:
     * @param y:
     * @param w:
     * @return: return the minimum risk value.
     */
    public int getMinRiskValue(int n, int m, int[] x, int[] y, int[] w) {
        // Write your code here

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 0; i < x.length; i++) {
            map[x[i]][y[i]] = w[i];
            map[y[i]][x[i]] = w[i];
        }
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        dfs(-1, n, 0, map, visited);
        return ret;
    }
    
    int ret = Integer.MAX_VALUE;
    
    public void dfs(int max, int n, int start, int[][] map, boolean[] visited) {
        if (start == n) {
            ret = Math.min(max, ret);
            return;
        }
        if (max >= ret) {
            return;
        }
        int tmp = max;
        for (int i = 0; i <= n; i++) {
            if (map[start][i] > 0 && !visited[i]) {
                max = Math.max(max, map[start][i]);
                visited[i] = true;
                dfs(max, n, i, map, visited);
                max = tmp;
                visited[i] = false;
            }
        }
    }
}
