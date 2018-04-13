import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        String[][] dp = new String[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(ball);
        int[][] distance = new int[m][n];
        for (int[] a : distance) Arrays.fill(a, Integer.MAX_VALUE);
        distance[ball[0]][ball[1]] = 0;
        dp[ball[0]][ball[1]]  = "";
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        String[] dirCharacters = {"d", "u", "r", "l"};
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int i = 0; i < directions.length; i++) {
                int[] dir = directions[i];
                String direction = dirCharacters[i];
                int x = node[0];
                int y = node[1];
                int cnt = 0;
                if (!inMaze(maze, x + dir[0], y + dir[1])) continue;
                boolean hasHole = false;
                while (inMaze(maze, x + dir[0], y + dir[1])) {
                    x += dir[0];
                    y += dir[1];
                    cnt++;
                    if (Arrays.equals(hole, new int[]{x, y}) && distance[node[0]][node[1]] + cnt <= distance[x][y] ) {
                        if (dp[x][y] == null || (dp[node[0]][node[1]] + direction).compareTo(dp[x][y]) < 0) {
                            dp[x][y] = dp[node[0]][node[1]] + direction;
                        }
                        distance[x][y] = distance[node[0]][node[1]] + cnt;
                        hasHole = true;
                        break;
                    }
                }
                if (hasHole) continue;
                if (distance[node[0]][node[1]] + cnt < distance[x][y]) {
                    distance[x][y] = distance[node[0]][node[1]] + cnt;
                    q.add(new int[]{x, y});
                    dp[x][y] = dp[node[0]][node[1]] + direction;
                } else if (distance[node[0]][node[1]] + cnt == distance[x][y]) {
                    if ((dp[node[0]][node[1]] + direction).compareTo(dp[x][y]) < 0) {
                        dp[x][y] = dp[node[0]][node[1]] + direction;   
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return dp[hole[0]][hole[1]] == null ? "impossible" : dp[hole[0]][hole[1]];
    }

    private boolean inMaze(int[][] maze, int x, int y) {
        return x >= 0 && y >=0 && x < maze.length && y < maze[0].length && maze[x][y] != 1;
    }
}
