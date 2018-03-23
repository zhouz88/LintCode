class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int idx = 0;
        for (int len = 0; len <= m + n - 2; len++) {
            if (len % 2 == 0) {
                for (int i = Math.min(len, m - 1); i >= len - Math.min(n - 1, len); i--) {
                    res[idx++] = matrix[i][len - i];
                }
            } else {
                for (int j = Math.min(len, n - 1); j >= len - Math.min(m - 1, len); j--) {
                    res[idx++] = matrix[len - j][j];
                }
            }
        }
        return res;
    }
}

