import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        bfs(image[sr][sc], newColor, image, sr, sc);
        return image;
    }
    
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1, 0},{0, -1}};

    private void bfs(int from, int to, int[][] image, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        image[i][j] = to;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : DIRECTIONS) {
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                if (x>=0&&y>=0&&x<image.length&&y<image[0].length&&image[x][y]==from) {
                    image[x][y]=to;
                    q.add(new int[]{x, y});
                }
            }
        }
    }
}
