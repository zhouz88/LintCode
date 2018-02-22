import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1;
        int l = 0, r = n - 1;

        while (l < r && up < down) {
            for (int j = l; j <= r; j++) {
                ret.add(matrix[up][j]);
            }
            for (int i = l + 1; i <= down; i++) {
                ret.add(matrix[i][r]);
            }

            for (int j = r - 1; j >= l; j--) {
                ret.add(matrix[down][j]);
            }

            for (int i = down - 1; i > up; i--) {
                ret.add(matrix[i][l]);
            }

            up++;
            down--;
            l++;
            r--;
        }

        if (up < down && l == r) {
            for (int i = up; i <= down; i++) {
                ret.add(matrix[i][l]);
            }
        }

        if (l < r && up == down) {
            for (int i = l; i <= r; i++) {
                ret.add(matrix[up][i]);
            }
        }

        if (l == r  && up == down) {
            ret.add(matrix[up][r]);
        }
        return ret;

    }
}
