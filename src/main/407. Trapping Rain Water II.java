import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0|| heightMap[0].length == 0) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(heightMap[o1[0]][o1[1]], heightMap[o2[0]][o2[1]]);
            }
        });

        int m = heightMap.length, n = heightMap[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m ; i++) {
            pq.add(new int[]{i, 0});
            visited[i][0] = true;
            pq.add(new int[]{i, n - 1});
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1 ; j++) {
            pq.add(new int[]{0, j});
            visited[0][j] = true;
            pq.add(new int[]{m - 1, j});
            visited[m -1][j] = true;
        }

        final int[][] directions = {{0,1},{-1,0},{0,-1},{1, 0}};
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            for (int[] dir : directions) {
                int x = dir[0] + node[0];
                int y = dir[1] + node[1];
                if (x>=0&&y>=0&&x<m&&y<n&&!visited[x][y]) {
                    visited[x][y] = true;
                    if (heightMap[x][y] < heightMap[node[0]][node[1]]) {
                        cnt += heightMap[node[0]][node[1]] - heightMap[x][y];
                        heightMap[x][y] = heightMap[node[0]][node[1]];
                    }
                    pq.add(new int[]{x, y});
                }
            }
        }

        return cnt;
    }
}
