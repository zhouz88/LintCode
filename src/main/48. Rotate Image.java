class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i <= (m - 1)/2; i++) {
            for (int j = 0; j <= m/2 - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m - j - 1][i];
                matrix[m - j - 1][i] = matrix[m - i  - 1][m - j - 1];
                matrix[m - i  - 1][m - j - 1] = matrix[j][m - i - 1];
                matrix[j][m - i - 1] = tmp;
            }
        }
    }
}
