import java.util.*;

public class Solution {
    private static class Robot {
        int x;
        int y;
        int dirX;
        int dirY;

        public Robot(int x, int y, int dirX, int dirY) {
            this.x = x;
            this.y = y;
            this.dirX = dirX;
            this.dirY = dirY;
        }
    }

    private int[][] matrix;
    private Robot robot;
    private boolean[][] cleanMap;
    private HashSet<String> set = new HashSet<>();

    public Solution(int[][] matrix) {
        this.matrix = matrix;
        this.robot = new Robot(0, 0, 1, 0);
        cleanMap = new boolean[matrix.length][matrix[0].length];
        map.put("-1 0", 0);
        map.put("0 1", 1);
        map.put("1 0", 2);
        map.put("0 -1", 3);
    }

    public void doIt() {
        clean();
        set.add(0 + " " + 0);
        dfs(0, 0, matrix, 1, 0);
        System.out.println(robot.dirX + ":" + robot.dirY);
        for (boolean[] dir : cleanMap) {
            System.out.println(Arrays.toString(dir));
        }
    }

    private boolean cleanNewGrid() {
        int a = robot.x + robot.dirX;
        int b = robot.y + robot.dirY;
        if (!set.contains(a + " " + b) && move()){
            set.add(a + " " + b);
            return true;
        } else {
            return false;
        }
    }

    private boolean move() {
        int a = robot.x + robot.dirX;
        int b = robot.y + robot.dirY;
        if (a < 0 || b < 0 || a >= matrix.length || b >= matrix[0].length || matrix[a][b] == 1) {
            return false;
        } else {
            int[][] out = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < out.length; i++) {
                for (int j = 0; j < out[0].length; j++) {
                    out[i][j] = matrix[i][j];
                }
            }
            robot.x += robot.dirX;
            robot.y += robot.dirY;
            out[robot.x][robot.y] = 3;
            for (int[] dir : out) {
                System.out.println(Arrays.toString(dir));
            }
            System.out.println("Next step");
            return true;
        }
    }

    private void turnRight(int n) {
        String d = robot.dirX + " " + robot.dirY;
        int index = map.get(d);
        index += n;
        index %= 4;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == index) {
                String start = e.getKey();
                String[] t = start.split(" ");
                robot.dirX = Integer.parseInt(t[0]);
                robot.dirY = Integer.parseInt(t[1]);
            }
        }
    }

    private void turnLeft(int n) {
        String d = robot.dirX + " " + robot.dirY;
        int index = map.get(d);
        index = (index + 4 - n) % 4;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == index) {
                String start = e.getKey();
                String[] t = start.split(" ");
                robot.dirX = Integer.parseInt(t[0]);
                robot.dirY = Integer.parseInt(t[1]);
            }
        }
    }

    private void clean() {
        cleanMap[robot.x][robot.y] = true;
    }

    public void dfs(int i, int j, int[][] matrix, int X, int Y) {
        int[] origin = new int[]{X, Y};
        for (int[] dir : DIRECTIONS) {
            turn(origin, dir); // 
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (cleanNewGrid()) {
                clean();//bug 1 move clean 反向了！
                dfs(x, y, matrix, dir[0], dir[1]);
                int[] back = {-dir[0], -dir[1]};//rotateRight(2);
                turn(dir, back);
                move();
                turn(back, origin);
            } else {
                turn(dir, origin);
            }
        }
    }

    private void backToOrigin(int[] back) {
        robot.x += robot.dirX;
        robot.y += robot.dirY;
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private static Map<String, Integer> map = new HashMap<>();

    public void cleanRoom(int[][] matrix) {
        dfs(0, 0, matrix, 1, 0);
    }

    public void turn(int[] first, int[] next) {
        int f = map.get(first[0] + " " + first[1]);
        int s = map.get(next[0] + " " + next[1]);
        if (s == f) return;
        if (f < s) {
            if (s - f <= Math.abs(4 - (s - f))) {
                turnRight(s - f);
            } else {
                turnLeft(4 - (s - f));
            }
        } else {
            if (f - s <= Math.abs(4 - (f - s))) {
                turnLeft(f - s);
            } else {
                turnRight(4 - (f - s));
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1},
        };
        Solution s = new Solution(matrix);
        s.doIt();
    }
}
