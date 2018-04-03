class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int m = M.length, n = M[0].length;
        int[][] up = new int[m][n];
        int[][] left = new int[m][n];
        int[][] upLeft = new int[m][n];
        int[][] upRight = new int[m][n];
        for (int i = 0; i < m; i++) {
            left[i][0] = (M[i][0] == 1 ? 1 : 0);
            upLeft[i][0] = left[i][0];
            upRight[i][n - 1] = (M[i][n - 1] == 1 ? 1 : 0);
        }
        for (int j = 0; j < n; j++) {
            up[0][j] = (M[0][j] == 1 ? 1 : 0);
            upLeft[0][j] = up[0][j];
            upRight[0][j] = up[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = (M[i][j] == 0 ? 0 : up[i - 1][j] + 1);
            }
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                left[i][j] = (M[i][j] == 0 ? 0 : left[i][j - 1] + 1);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j< n; j++) {
                upLeft[i][j] = (M[i][j] == 0 ? 0 : upLeft[i - 1][j - 1] + 1);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                upRight[i][j] = (M[i][j] == 0 ? 0 : upRight[i - 1][j + 1] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                max = Math.max(max, Math.max(Math.max(up[i][j], left[i][j]), Math.max(upLeft[i][j], upRight[i][j])));
            }
        }
        return max;
    }
}
