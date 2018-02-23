public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a = 0;
        for (int i = 0; i <= 32; i++) {
            int k = n >> i;
            if ((k & 1) == 1) a |= (1 << (31 - i));
        }
        return a;
    }
}
