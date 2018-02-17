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

    int[][] tree;
    int[][] nums;
    int m;
    int n;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) 
            return;
        
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m + 1][n + 1];
        nums = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) 
            return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) 
            return 0;
        return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }
    
    public int sum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
