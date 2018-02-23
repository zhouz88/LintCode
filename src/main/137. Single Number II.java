class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
       for (int i = 32; i >= 0; i --) {
           int cnt = 0;
           for (int k : nums) {
               if (((k >> i) & 1) == 1) {
                   cnt++;
               }
           }
           if (cnt%3 != 0) {
               res |= (1 << i);
           }
       }
       return res;
    }
}
