class Solution {//care about overflow
    public int trailingZeroes(int n) {
        long N = n;
        long tmp = 5;
        int cnt = 0;
        while (N >= tmp) {
            cnt += (int) (n/tmp);
            tmp *= 5;
        }
        return cnt;
    }
}
