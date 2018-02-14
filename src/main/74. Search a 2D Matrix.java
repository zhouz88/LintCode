class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0) {
            return false;
        }
        
        int l = 0;
        int r = matrix[0].length -  1;

        while (true) {
            if (matrix[l][r] == target) {
                return true;
            }
            if (matrix[l][r] > target) {
                r--;
            } else {
                l++;
            }
            if (r < 0 || l == matrix.length) {
                return false;
            }
        }
    }
}
