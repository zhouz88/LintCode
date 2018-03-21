class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n*2 - 1][n][n];
        int len, x1, x2;
        dp[0][0][0] = grid[0][0] == 1 ? 1 : 0;
        if(grid[0][0] == - 1) dp[0][0][0] =-1;
        for ( len = 1; len < 2 * n - 1; len++) {
            for (x1 = 0; x1 < n;  x1++) {
                for (x2 = 0; x2 < n; x2++) {
                    int y2 = len - x2;
                    int y1 = len - x1;
                    if (x1 >= 0 && x1 < n & y1 >= 0 && y1 < n && x2 >= 0 && x2 < n & y2 >= 0 && y2 < n  && grid[x1][y1] != -1 && grid[x2][y2] != -1) {
                        boolean flag = false;
                        int a = 0, b = 0, c = 0, d = 0;
                        if (len >= 1 && x1 >= 1 && y2 >= 1 && grid[x1 - 1][y1] != -1 && grid[x2][y2 - 1] != -1 ) {
                            if ( dp[len - 1][x1 - 1][x2] >= 0) {
                                flag = true;
                                a = dp[len - 1][x1 - 1][x2];
                            }
                        }
                        if (len >= 1 && x1 >= 1 && x2 >= 1 && grid[x1 - 1][y1] != -1 && grid[x2 - 1][y2] != -1 ) {
                            if (dp[len - 1][x1 - 1][x2 - 1] >= 0) {
                                flag = true;

                                b =  dp[len - 1][x1 - 1][x2 - 1];
                            }
                        }
                        if (len >= 1 && y1 >= 1 && x2 >= 1 && grid[x1][y1 - 1] != -1 && grid[x2 - 1][y2] != -1 ) {
                            if (dp[len - 1][x1][x2 - 1] >= 0) {
                                flag = true;

                                c = dp[len - 1][x1][x2 - 1];
                            }
                        }
                        if (len >= 1 && y1 >= 1 && y2 >= 1 &&grid[x1][y1 - 1] != -1 && grid[x2][y2 - 1] != -1 ) {
                            if ( dp[len - 1][x1][x2] >= 0) {
                                flag = true;
                                d = dp[len - 1][x1][x2];
                            }
                        }
                        if (!flag) {
                            dp[len][x1][x2] = -1;
                            continue;
                        }
                        if (x1 == x2) {
                            dp[len][x1][x2] = grid[x1][y1] + Math.max(Math.max(a,b), Math.max(c,d));
                        } else {
                            dp[len][x1][x2] = grid[x2][y2] + grid[x1][y1] + Math.max(Math.max(a,b), Math.max(c,d));
                        }
                    } else if (x1 >= 0 && x1 < n & y1 >= 0 && y1 < n && x2 >= 0 && x2 < n & y2 >= 0 && y2 < n ) {
                        dp[len][x1][x2] = -1;
                    }
                }
            }
        }
        return dp[2 * n - 2][n - 1][n - 1] >= 0 ? dp[2 * n - 2][n - 1][n - 1]  :0;
    }
}
