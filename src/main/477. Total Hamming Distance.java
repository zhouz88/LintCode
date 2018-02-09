class Solution {
    public int totalHammingDistance(int[] nums) {
        int cnt1;
        int total = 0;
        for (int i = 0; i < 32; i++) {
            cnt1 = 0;
            for (int k : nums) {
                
                    cnt1+= ((k >> i)&1);
            }
            total += cnt1 * (nums.length - cnt1);
        }
        return total;
    }
}
