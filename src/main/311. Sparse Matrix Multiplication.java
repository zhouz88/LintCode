class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;
        int[][] ret = new int[m][k];
        int i,  j , t;
        for (i = 0; i < n; i++) 
            for (j = 0; j < m; j++) 
                if (A[j][i] != 0) 
                    for (t = 0; t < k; t++) //wrong 1 pointer typo
                        if (B[i][t] != 0) 
                            ret[j][t] += A[j][i]*B[i][t];
   
        return ret;
    }
}
