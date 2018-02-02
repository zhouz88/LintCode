public class Solution {
    /*
     * @param A: An integer array
     * @return: An integer
     */
     public int singleNumberII(int[] A) {
        if (A == null) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int k : A) {
                int tmp = (k >> i) & 1;
                if (tmp == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                total += 1 << i;
            }
        }
        return total;
    }
}
