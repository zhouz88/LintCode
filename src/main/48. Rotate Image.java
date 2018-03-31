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

//
class Solution {
    public void rotate(int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            int l = 0, r = matrix.length - 1;
            while (l < r) {
                int tmp = matrix[r][j];
                matrix[r][j] = matrix[l][j];
                matrix[l][j] = tmp;
                r--;
                l++;
            }
        }
       for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
       }
    }
}
