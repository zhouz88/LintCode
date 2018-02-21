public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        int[] B = new int[A.length];
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            percolateup(B, A[i], size);
            size++;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }
    }
    
    public void percolateup(int[] A, int target, int size) {
        A[size] = target;
        while (size != 0) {
            int m = (size - 1)/2;
            if (A[m] < A[size]) {
                break;
            } else {
                A[m] ^= A[size];
                A[size] ^= A[m];
                A[m] ^= A[size];
                size = m;
            }
        }
        return;
    }
}
