import java.util.*;
class Solution {
    public String findShortestWay(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] dis : distance) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int max = Integer.MAX_VALUE;
        final int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        String res = null;
        String[][] dp = new String[m][n];
        dp[start[0]][start[1]] = "";
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : directions) {
                int x = node[0];
                int y = node[1];
                int total = 0;
                if (x+dir[0]>=0&&y+dir[1]>=0&&x+dir[0]<m&&y+dir[1]<n&&maze[x+dir[0]][y+dir[1]]!=1) {
                    boolean flag = false;
                    while (x+dir[0]>=0&&y+dir[1]>=0&&x+dir[0]<m&&y+dir[1]<n&&maze[x+dir[0]][y+dir[1]]!=1) {
                        total++;
                        x += dir[0];
                        y += dir[1];
                        if (destination[0] == x && destination[1] == y) {
                            flag = true;
                            if (distance[node[0]][node[1]] + total < max) {
                                char D = getUDLR(x, y, node[0], node[1]);
                                res = dp[node[0]][node[1]] + D;
                                max = distance[node[0]][node[1]] + total;
                            } else if (distance[node[0]][node[1]] + total == max){
                                char D = getUDLR(x, y, node[0], node[1]);
                                String tmp = dp[node[0]][node[1]] + D;
                                res = (tmp).compareTo(res) < 0 ? tmp : res;
                            }
                        }
                    }
                    if (flag) continue;
                    if (distance[x][y] > distance[node[0]][node[1]] + total) {
                        distance[x][y] = distance[node[0]][node[1]] + total;
                        q.add(new int[]{x, y});
                        char D = getUDLR(x,y, node[0], node[1]);
                        dp[x][y] = dp[node[0]][node[1]] + D;

                    } else if (distance[x][y] == distance[node[0]][node[1]] + total) {
                        q.add(new int[]{x, y});
                        char D = getUDLR(x,y, node[0], node[1]);
                        String tmp = dp[node[0]][node[1]] + D;
                        dp[x][y] = tmp.compareTo(dp[x][y]) < 0 ?  tmp : dp[x][y];
                    }
                }
            }
        }
        return res == null ? "impossible" : res;
    }

    private char getUDLR(int x, int y, int x0, int y0) {
        if (x > x0) {
            return 'd';
        } else if (x < x0) {
            return 'u';
        } else if (y > y0) {
            return 'r';
        } else if (y < y0) {
            return 'l';
        } else {
            return ' ';
        }
    }
}
