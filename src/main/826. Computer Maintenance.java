public class Solution {
    /**
     * @param n: the rows of matrix
     * @param m: the cols of matrix
     * @param Badcomputers: the bad computers
     * @return: The answer
     */
    public int maintenance(int m, int n, Point[] Badcomputers) {
        // Write your code here
        this.M = new int[m][n];
        for (Point k : Badcomputers) {
            M[k.x][k.y] = 1;
        }
        int[] lDp = new int[m];
        int[] rDp = new int[m];
        
        rDp[0] = n;
        lDp[0] = ltol(0) + 1;
        
        for (int i = 1; i < m; i++) {
            lDp[i] = Math.min(lDp[i - 1] + ltol(i),  rDp[i - 1] + n - 1) + 1;
            rDp[i] = Math.min(lDp[i - 1] + n - 1, rDp[i - 1] + rtor(i)) + 1;
        }
        return Math.min(lDp[m - 1], rDp[m - 1]) - 1;
    }

    int[][] M ;

    private int ltol(int row) {//row , 0
        int j = M[0].length - 1;
        while (j >= 0 && M[row][j] == 0) {
            j--;
        }
        if (j == -1) return 0;
        return 2 * j;
    }

    private int rtor(int row) {
        int j = 0;
        while (j < M[0].length && M[row][j] == 0) {
            j++;
        }
        if (j == M[0].length) return 0;
        return 2 * (M[0].length - 1 - j);
    }
}
