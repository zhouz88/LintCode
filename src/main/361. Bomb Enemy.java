class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] up = getUp(grid);
        int[][] down = getDown(grid);
        int[][] left = getLeft(grid);
        int[][] right = getright(grid);
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return max;
    }

    private int[][] getright(char[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int i, j;
        for (i = 0; i < grid.length; i++) {
            if (grid[i][grid[0].length - 1] == 'E') {
                dp[i][grid[0].length - 1] = 1;
            }
        }
        for (j = grid[0].length - 2; j >= 0; j--) {
            for (i = 0; i < grid.length; i++) {
                if (grid[i][j] == 'E') {
                    dp[i][j] = dp[i][j + 1] + 1;
                } else if (grid[i][j] == '0') {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }
        return dp;
    }

    private int[][] getLeft(char[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int i, j;
        for (i = 0; i < grid.length; i++) {
            if (grid[i][0] == 'E') {
                dp[i][0] = 1;
            }
        }
        for (j = 1; j < grid[0].length; j++) {
            for (i = 0; i < grid.length; i++) {
                if (grid[i][j] == 'E') {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else if (grid[i][j] == '0') {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp;
    }

    private int[][] getDown(char[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int i, j;
        for (j = 0; j < grid[0].length; j++) {
            if (grid[grid.length - 1][j] == 'E') {
                dp[grid.length - 1][j] = 1;
            }
        }
        for (i = grid.length - 2; i >= 0; i--) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    dp[i][j] = dp[i + 1][j] + 1;
                } else if (grid[i][j] == '0') {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp;
    }

    private int[][] getUp(char[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int i, j;
        for (j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 'E') {
                dp[0][j] = 1;
            }
        }
        for (i = 1; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else if (grid[i][j] == '0') {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }
}
