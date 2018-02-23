class Solution {//// TLE
    public int calculateMinimumHP(int[][] m) {
        dfs(m, 0, 0, m[0][0], m[0][0]);
        if (res >= 0) {
            return 1;
        } else {
            return -res + 1;
        }
    }

    private int[][] DIRECTIONS = {{0 ,1},{1, 0}};
    int res = -99999999;

    private void dfs(int[][] m, int i, int j, int sum, int minState) {
        // System.out.println(minState);
        if (minState <= res) {// pruning
            return;
        }
        if (i == m.length - 1 && j == m[0].length - 1) {
            res = minState;
            return;
        }
        
        int tmp = minState;
        for (int[] direction : DIRECTIONS) {
            int x = direction[0] + i;
            int y = direction[1] + j;
            if (x < m.length && y < m[0].length) {
                sum += m[x][y];
                minState = Math.min(sum, minState);
                dfs(m, x, y, sum, minState);
                sum -= m[x][y];
                minState = tmp;
            }
        }
    }
}

//DP
class Solution {//搜索路径里面累计最小值得最大值
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        
        int m = dungeon.length, n = dungeon[0].length;
        
        int[][] dp = new int[m][n];
        
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        
        int i, j;
        for (i = m - 2; i >= 0; i --) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        
        for (j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        
        for (i = m - 2; i>=0;i--) {
            for (j = n - 2; j>=0 ; j--) {
                int left = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                int down = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                dp[i][j] = Math.min(left, down);
            }
        }
        
        return dp[0][0];
    }
}
