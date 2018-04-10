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

//dfs
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        final int[][] directions = {{1, 0},{0, 1},{-1, 0},{0, -1}};
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
            dfs(pacific, i, 0, matrix, directions);
            dfs(atlantic, i, n - 1, matrix, directions);
        }
        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
            dfs(pacific, 0, j, matrix, directions);
            dfs(atlantic, m-1, j, matrix, directions);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlantic[i][j]&&pacific[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] pacific, int startI, int startJ, int[][] matrix, int[][] directions) {
        for (int[] dir : directions) {
            int x = dir[0] + startI;
            int y = dir[1] + startJ;
            if (x>=0&&y>=0&&x<matrix.length&&y<matrix[0].length&&!pacific[x][y]&&matrix[x][y]>=matrix[startI][startJ]) {
                pacific[x][y]=true;
                dfs(pacific,x,y,matrix,directions);
            }
        }
    }
}
