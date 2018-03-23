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
        int max = 999999999;
        final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        List<String> res = new ArrayList<>();
        List<String>[][] dp = new ArrayList[m][n];
        dp[start[0]][start[1]] = new ArrayList<>();
        dp[start[0]][start[1]].add("");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {
                int[] node = q.poll();
                //System.out.println(distance[node[0]][node[1]] + ":" + node[0] +":"+ node[1]);
                if (destination[0] == node[0] && destination[1] == node[1]) {
                    if (distance[node[0]][node[1]] <= max ) {
                        max = distance[node[0]][node[1]];
                        if (distance[node[0]][node[1]] < max) res.clear();
                        res.addAll(dp[destination[0]][destination[1]]);
                    }
                    continue;
                }
                for (int[] dir : directions) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    int total = 1;
                    if (destination[0] == x && destination[1] == y) {
                        if (distance[node[0]][node[1]] + total <= max) {
                            max = distance[node[0]][node[1]] + total;
                            // System.out.println(distance[node[0]][node[1]] + ":" + node[0] +":"+ node[1]);
                            if (distance[node[0]][node[1]] + total < max) res.clear();
                            char D = getUDLR(x, y, node[0], node[1]);
                            List<String> list = new ArrayList<>();
                            for (String k : dp[node[0]][node[1]]) {
                                String tmp = k + D;
                                list.add(tmp);
                            }
                            res.addAll(list);
                        }
                        continue;
                    }
                    if (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
                        boolean flag = false;
                        while (x + dir[0] >= 0 && y + dir[1] >= 0 && x + dir[0] < m && y + dir[1] < n && maze[x + dir[0]][y + dir[1]] != 1) {
                            total++;
                            x += dir[0];
                            y += dir[1];
                            if (destination[0] == x && destination[1] == y) {
                                flag = true;
                                if (distance[node[0]][node[1]] + total <= max) {
                                    max = distance[node[0]][node[1]] + total;
                                    if (distance[node[0]][node[1]] + total < max) res.clear();
                                    char D = getUDLR(x, y, node[0], node[1]);
                                    List<String> list = new ArrayList<>();
                                    for (String k : dp[node[0]][node[1]]) {
                                        String tmp = k + D;
                                        list.add(tmp);
                                    }
                                    res.addAll(list);
                                    break;
                                }
                            }
                        }
                        if (flag) continue;
                        if (distance[x][y] >= distance[node[0]][node[1]] + total) {
                            distance[x][y] = distance[node[0]][node[1]] + total;
                            q.add(new int[]{x, y});
                            dp[x][y] = new ArrayList<>();
                            char D = getUDLR(x,y, node[0], node[1]);
                            for (String k : dp[node[0]][node[1]]) {
                                String tmp = k + D;
                                dp[x][y].add(tmp);
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(res);
        if (res.size() == 0) {
            return "impossible";
        }
        return res.get(0);
    }

    private char getUDLR(int x, int y, int x0, int y0) {
        if (x > x0) {
            return 'd';
        } else if (x < x0) {
            return 'u';
        }
        if (y > y0) {
            return 'r';
        } else if (y < y0) {
            return 'l';
        }
        return ' ';
    }
}
