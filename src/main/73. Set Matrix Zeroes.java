import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowOk = false;
        boolean colOk = false;
        int i, j;
        
        for (i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colOk = true;
                break;
            }
        }

        for (j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowOk = true;
                break;
            }
        }
        
        for (i = 1; i < matrix.length; i++) {
            for (j = 1; j < matrix[0].length; j++) {
                matrix[i][0] = (matrix[i][j] == 0 ? 0 : matrix[i][0]);
                matrix[0][j] = (matrix[i][j] == 0 ? 0 : matrix[0][j]);
            }
        }
        
        for (i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (rowOk) {
            Arrays.fill(matrix[0], 0);
        }
        
        if (colOk) {
            for (i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
