import java.util.*;

class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        int m = matrix.length, n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            bfs(i, 0, matrix, set1, m, n);
        }
        
        for (int j = 1; j < n; j++) {
            bfs(0, j, matrix, set1, m, n);
        }
        
        for (int j = 0; j < n; j++) {
            bfs(m - 1, j, matrix, set2, m, n);
        }
        
        for (int i = 0; i < m; i++) {
            bfs(i, n - 1, matrix, set2, m, n);
        }
        
        List<int[]> ret = new ArrayList<>();
        
        for (int k : set1) {
            if (set2.contains(k)) {
                ret.add(new int[]{k/n, k%n});
            }
        }
        
        return ret;
    }

    private static int[][] Directions = {{0, 1},{1, 0},{-1, 0},{0, -1}};

    private void bfs(int i, int j, int[][] matrix, Set<Integer> set1, int m, int n) {
        set1.add(i * n + j);
        Queue<Integer> q = new LinkedList<>();
        q.add(i*n+j);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int[] dir : Directions) {
                int x = dir[0] + node/n;
                int y = dir[1] + node%n;
                if (x>=0&&y>=0&&x<m&&y<n&&!set1.contains(x*n + y)&&matrix[x][y]>=matrix[node/n][node%n]) { //bug1
                    set1.add(x*n + y); //bug 1
                    q.add(x*n+y);
                }
            }
        }
        
    }
}
