class Solution {
    long  max = Long.MIN_VALUE;

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int i, j1, j2;
        long[] sum = new long[m + 1];
        for (j1 = 0; j1 < n; j1++) {
            long[] row = new long[m];
            for (j2 = j1; j2 < n; j2++) {
                for (i = 0; i < m; i++) {
                    row[i] += matrix[i][j2];
                    sum[i + 1] = sum[i] + row[i];
                }
                mergeSort(sum, 0, m, k);
            }
        }
        return (int)max;
    }

    private void mergeSort(long[] sum, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int mid = (end - start)/2 + start;
        mergeSort(sum, start, mid, k);
        mergeSort(sum, mid + 1, end, k);
        long[] array = new long[end - start + 1];
        int idx = 0;
        int l = mid, r = end;
        while (l >= start && r >= mid + 1) {
            while (l >= start && sum[l] + k >= sum[r]) {
                max = Math.max(sum[r] - sum[l], max);
                l--;
            }
            r--;
        }
        l = start;
        r = mid + 1;
        while (l <= mid && r <= end) {
            if (sum[l] < sum[r]) {
                array[idx ++] = sum[l++];
            } else {
                array[idx ++] = sum[r++];
            }
        }
        while (l <= mid) {
            array[idx ++] = sum[l++];
        }
        while (r <= end) {
            array[idx ++] = sum[r++];
        }
        for (int i = start; i <= end; i++) {
            sum[i] = array[i - start];
        }
    }
    
}
