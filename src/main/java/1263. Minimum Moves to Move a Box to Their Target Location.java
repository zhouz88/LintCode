import java.util.*;

class Solution {
    int m, n;
    char[][] grid;
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minPushBox(char[][] grid) {
        Queue<int[]> q1 = new ArrayDeque<>();
        int[] man = null, box = null, destination = null;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T') {
                    grid[i][j] = '.';
                    destination = new int[]{i, j};
                } else if (grid[i][j] == 'S') {
                    man = new int[]{i, j};
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'B') {
                    box = new int[]{i, j};
                    grid[i][j] = '.';
                }
            }
        }
        Set<String> set = new HashSet<>();
        if (goUp(man, box)) {
            set.add(box[0] - 1 + " " + box[1] + " " + box[0] + " " + box[1]);
            q1.add(new int[]{box[0] - 1, box[1], box[0], box[1]});
        }
        if (goDown(man, box)) {
            set.add(box[0] + 1 + " " + box[1] + " " + box[0] + " " + box[1]);
            q1.add(new int[]{box[0] + 1, box[1], box[0], box[1]});
        }
        if (goLeft(man, box)) {
            set.add(box[0] + " " + (box[1] - 1) + " " + box[0] + " " + box[1]);
            q1.add(new int[]{box[0], box[1] - 1, box[0], box[1]});
        }
        if (goRight(man, box)) {
            set.add(box[0] + " " + (box[1] + 1) + " " + box[0] + " " + box[1]);
            q1.add(new int[]{box[0], box[1] + 1, box[0], box[1]});
        }
        if (q1.isEmpty()) return -1;
        int step = 0;
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int z = 0; z < size; z++) {
                int[] node = q1.poll();
                box = new int[]{node[2], node[3]};
                man = new int[]{node[0], node[1]};
                if (node[2] == destination[0] && node[3] == destination[1]) {
                    return step;
                }
                if (node[0] == node[2] - 1) {
                    //up
                    goFromUp(box, set, q1);
                    if (goDown(man, box)) {
                        goFromDown(box, set, q1);
                    }
                    if (goLeft(man, box)) {
                        goFromLeft(box, set, q1);
                    }
                    if (goRight(man, box)) {
                        goFromRight(box, set, q1);
                    }
                } else if (node[0] == node[2] + 1) {
                    //down
                    goFromDown(box, set, q1);
                    if (goUp(man, box)) {
                        goFromUp(box, set, q1);
                    }
                    if (goLeft(man, box)) {
                        goFromLeft(box, set, q1);
                    }
                    if (goRight(man, box)) {
                        goFromRight(box, set, q1);
                    }
                } else if (node[1] == node[3] - 1) {
                    //left
                    goFromLeft(box, set, q1);
                    if (goUp(man, box)) {
                        goFromUp(box, set, q1);
                    }
                    if (goDown(man, box)) {
                        goFromDown(box, set, q1);
                    }
                    if (goRight(man, box)) {
                        goFromRight(box, set, q1);
                    }
                } else {
                    //right
                    goFromRight(box, set, q1);
                    if (goUp(man, box)) {
                        goFromUp(box, set, q1);
                    }
                    if (goDown(man, box)) {
                        goFromDown(box, set, q1);
                    }
                    if (goLeft(man, box)) {
                        goFromLeft(box, set, q1);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void goFromRight(int[] box, Set<String> set, Queue<int[]> q1) {
        String next = box[0] + " " + box[1] + " " + box[0] + " " + (box[1] - 1);
        if (box[1] - 1 >= 0 && !set.contains(next) && grid[box[0]][box[1] - 1] == '.') {
            set.add(next);
            q1.add(new int[]{box[0], box[1], box[0], box[1] - 1});
        }
    }

    private void goFromLeft(int[] box, Set<String> set, Queue<int[]> q1) {
        String next = box[0] + " " + box[1] + " " + box[0] + " " + box[1] + 1;
        if (box[1] + 1 < n && !set.contains(next) && grid[box[0]][box[1] + 1] == '.') {
            set.add(next);
            q1.add(new int[]{box[0], box[1], box[0], box[1] + 1});
        }
    }

    private void goFromDown(int[] box, Set<String> set, Queue<int[]> q1) {
        String next = box[0] + " " + box[1] + " " + (box[0] - 1) + " " + box[1];
        if (box[0] - 1 >= 0 && !set.contains(next)  && grid[box[0] - 1][box[1]] == '.') {
            set.add(next);
            q1.add(new int[]{box[0], box[1], box[0] - 1, box[1]});
        }
    }

    private void goFromUp(int[] box, Set<String> set, Queue<int[]> q1) {
        String next = box[0] + " " + box[1] + " " + (box[0] + 1) + " " + box[1];
        if (box[0] + 1 < m && !set.contains(next) && grid[box[0] + 1][box[1]] == '.') {
            set.add(next);
            q1.add(new int[]{box[0], box[1], box[0] + 1, box[1]});
        }
    }

    private boolean goUp(int[] man, int[] box) {
        return bfs(man, box[0] - 1, box[1] , box);
    }

    private boolean goDown(int[] man, int[] box) {
        return bfs(man, box[0] + 1, box[1], box);
    }

    private boolean goLeft(int[] man, int[] box) {
        return bfs(man, box[0], box[1] - 1, box);
    }

    private boolean goRight(int[] man, int[] box) {
        return bfs(man, box[0], box[1] + 1, box);
    }

    private boolean bfs(int[] man, int iEnd, int jEnd, int[] box) {
        if (iEnd < 0 || iEnd >= m || jEnd < 0 || jEnd >= n) {
            return false;
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(man);
        boolean[][] visited = new boolean[m][n];
        visited[man[0]][man[1]] = true;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            if (node[0] == iEnd && node[1] == jEnd) {
                return true;
            }
            for (int[] dir : DIRECTIONS) {
                int x = dir[0] + node[0];
                int y = dir[1] + node[1];
                if (Arrays.equals(new int[]{x, y}, box)) continue;
                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '.' && !visited[x][y]) {
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
