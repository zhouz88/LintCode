class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m *n];
        int idx = 0;
        int step = 0;
        for (int sum = 0; sum <= m + n - 2; sum ++) {
            if (sum % 2 == 0) {
                for (int i = Math.min(sum, m - 1); i >= Math.max(0, sum - n + 1); i--) {
                    res[idx++] = matrix[i][sum - i];
                }
            } else {
                for (int j = Math.min(sum, n - 1); j >= Math.max(0, sum - m + 1); j--) {
                    res[idx++] = matrix[sum - j][j];
                }
            }
        }
        return res;
    }
}
