public class Solution {
    /*
    http://www.lintcode.com/en/problem/trapping-rain-water-ii/#
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(new valComparator());
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n -1] = true;
            pq.add(new Point( i, 0, heights[i][0]));
            pq.add(new Point( i, n - 1, heights[i][n - 1]));
        }
        for (int j = 0; j < n; j++) {
            visited[0][j] = true;
            visited[m-1][j] = true;
            pq.add(new Point( 0, j, heights[0][j]));
            pq.add(new Point( m - 1, j, heights[m - 1][j]));
        }
        int res = 0;
        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
        while (!pq.isEmpty()) {
            Point node = pq.poll();
            for (int[] dir : directions) {
                int x = dir[0] + node.x;
                int y = dir[1] + node.y;
                if (x>=0&&y>=0&&x<m&&y<n&&!visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, node.val - heights[x][y]);
                    pq.add(new Point(x,y, Math.max(heights[x][y], node.val)));
                }
            }
        }
        return res;
    }
    
    class valComparator implements Comparator<Point> {
         @Override
         public int compare(Point a, Point b) {
             if (a.val == b.val ) {
                 return 0;
             }
             return a.val > b.val ? 1 : -1;
         }
    }
    
    class Point{
        int x;
        int y;
        int val;
        public Point(int a, int b, int c) {
            x = a;
            y = b;
            val = c;
        }
    }
}
