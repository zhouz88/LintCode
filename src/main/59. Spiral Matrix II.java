class Solution {
    public int[][] generateMatrix(int n) {
         int[][] M = new int[n][n];
         int idx = 1;
         int up = 0, down = n - 1;
         int l = 0, r = n - 1;
         while (up < down && l < r) {
             for (int j = l; j <= r; j++) {
                 M[up][j] = idx++;
             }
             for (int i = up + 1; i <= down; i++) {
                 M[i][r] = idx++;
             }
             for (int j = r - 1; j >= l; j--) {
                 M[down][j] = idx++;
             } 
             for (int i = down - 1; i >= up + 1; i--) {
                 M[i][l] = idx++;
             }
             up++;
             down--;
             l++;
             r--;
         }
         if (up == down && l == r) {
             M[up][l] = idx++;
         }
         return M;
    }
}
