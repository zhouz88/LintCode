class Solution {
    public int findNthDigit(int N) {
        if (N <= 9) return N;
        long len = 1, total = 0, numsOfCurLen = 9, big = 0;
        while (total + numsOfCurLen * len < N) {
            total += numsOfCurLen * len;
            len++;
            numsOfCurLen *= 10;
            big = big * 10 + 9;
        }
        long num = N - total - 1;
        long cur = (num/(len)) + big + 1; 
        long idx = num%(len);
        return (cur + "").charAt((int)idx) - '0';
    }
}
