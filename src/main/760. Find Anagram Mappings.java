import java.util.Arrays;

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            A[i] = (A[i] << 8) + i;
            B[i] = (B[i] << 8) + i;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[A[i] & 0xff] = B[i] & 0xff;
        }
        return res;
    }
}
