class NumArray {
    private int[] nums;
    private int[] Bits;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.Bits = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            change(i, nums[i]);
        }
    }
    
    private void change(int i, int val) {
        i++;
        while (i < Bits.length) {
            Bits[i] += val;
            i += (i & -i);
        }
    }
    

    public void update(int i, int val) {
        change(i, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }
    
    public int sum(int i) {
        i++;
        int total = 0;
        while (i > 0) {
            total += Bits[i];
            i -= (-i&i);
        }
        return total;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */


//2d 



public class NumMatrix {

    private int[][] Bits;
    private int[][] matrix;
    private int m;
    private int n;
    public NumMatrix(int[][] matrix) {
         if (matrix.length == 0 || matrix[0].length == 0) 
            return;
         this.matrix = matrix;
         this.Bits = new int[matrix.length + 1][matrix[0].length + 1];
         m = matrix.length;
         n = matrix[0].length;
         for (int i = 0; i < m;  i++)
             for(int j = 0; j < n; j++)
                change(Bits, i, j, matrix[i][j]);

    }

    private void change(int[][] Bits, int row, int col, int val) {
        for (int i = row + 1; i <= m; i += (i&-i)) {
            for (int j = col + 1; j <= n; j += (j&-j)) {
                Bits[i][j] += val;
            }
        }
    }

    public void update(int row, int col, int val) {
        change(Bits, row, col, val - matrix[row][col]);
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 , col2) + sum(row1 - 1, col1 - 1) - sum(row2, col1 - 1) - sum(row1 - 1, col2);
    }

    private int sum(int row , int col) {
        int total = 0;
        for (int i = row + 1; i > 0; i -= (i&-i)) {
            for (int j = col + 1; j > 0; j -= (j&-j)) {
                total += Bits[i][j];
            }
        }
        return total;
    }
}
