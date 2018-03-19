class Solution {
    public int[] constructArray(int n, int k) {
         int[] res = new int[n];
         if (k%2 == 0) {
             int i = 1, j = n;
             int idx = 0;
             while (idx < k) {
                 res[idx++] = i;
                 res[idx++] = j;
                 i++;
                 j--;
             }
             while (idx < n) {
                 res[idx++] = j--;
             }
         } else {
             int i = 1, j = n;
             int idx = 0;
             while (idx < k - 1) {
                 res[idx++] = i;
                 res[idx++] = j;
                 i++;
                 j--;
             }
             while (idx < n) {
                 res[idx++] = i++;
             }
         }
        return res;
    }
}
