class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;// 0 xor every equals evry;
        for (int k : nums) {
            sum ^= k;
        }
        return sum;
    }
}
