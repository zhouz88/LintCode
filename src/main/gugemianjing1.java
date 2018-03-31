//public class Solution{
//
//    private boolean move() {
//
//    }
//
//    private void turnRight(int n) {
//
//    }
//
//    private void turnLeft(int n) {
//
//    }
//
//    private void clean() {
//
//    }
//
//    public void dfs(int i, int j, int[][] matrix, boolean[][] visited, int d) {
//
//    }
//
//    private int[] getDirections(int k) {
//        if (k == 0) return DIRECTIONS[0];
//        if (k == 1) return DIRECTIONS[1];
//        if (k == 2) return DIRECTIONS[2];
//        if (k == 3) return DIRECTIONS[3];
//        return new int[0];
//    }
//
//    private static final int[][] DIRECTIONS = {{0, 1},{-1,0},{1, 0},{0, -1}};
//
//    public void cleanRoom() {
//
//    }
//}

public class Solution {
    public int getMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][][] dp = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    max = Math.max(max, dfs(i, j, matrix, dp , 0));
                    max = Math.max(max, dfs(i, j, matrix, dp , 1));
                    max = Math.max(max, dfs(i, j, matrix, dp ,  2));
                    max = Math.max(max, dfs(i, j, matrix, dp , 3));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] matrix, int[][][] dp, int dir) {
        if (matrix[i][j] == 0) {
            return 0;
        }
        int sum = matrix[i][j];
        i += getDir(dir)[0];
        j += getDir(dir)[1];
        if (i<0||j<0||i>=matrix.length||j>=matrix[0].length||matrix[i][j]==0) {
            return sum;
        }
        int max = -1;
        for (int k : dirs) {
            if (k == 3 - dir) continue;
            if (dp[i][j][dir] != -1) {
                max =  Math.max(max, dp[i][j][dir] + sum);
            } else {
                max = Math.max(max, dfs(i, j, matrix, dp, k) + sum);
            }
        }
        dp[i][j][dir] = max - sum;
        return max;
    }

    private int[] dirs = {0, 1, 2, 3};

    private int[] getDir(int i) {
        if (i == 0) return new int[]{0 ,-1};
        if (i == 1) return new int[]{-1 ,0};
        if (i == 2) return new int[]{1, 0};
        if (i == 3) return new int[]{0, 1};
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0 ,1 ,0 ,3 ,4},
                {2, 2 ,0 ,7, 0},
                {0 ,4 ,5 ,6, 2},
                {0 ,0, 0, 0 ,0},
                {0 ,2 ,0, 0 ,2 },
        };
        System.out.println(new Solution().getMax(matrix));
    }
}
