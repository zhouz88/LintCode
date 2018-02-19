import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int i, j;
        for(i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : directions) {
                int x = dir[0] + node[0];
                int y = dir[1] + node[1];
                if (x>=0&&y>=0&&x<m&&y<n&&matrix[x][y] != 0) {
                    if (matrix[x][y] == Integer.MAX_VALUE) {
                        matrix[x][y] = matrix[node[0]][node[1]] + 1;
                        q.add(new int[]{x, y});
                    } else if (matrix[x][y] > matrix[node[0]][node[1]] + 1) {
                        matrix[x][y] = matrix[node[0]][node[1]] + 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        
        return matrix;
    }
}
