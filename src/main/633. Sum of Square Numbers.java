class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0) {
            return true;
        }
        int len = (int) Math.sqrt(c+0.5);
        for (int i = 1; i <= len; i++) {
            int tmp = c - i*i;
            int t = (int)Math.sqrt(tmp +0.5);
            if (t*t == tmp) return true;
        }
        return false;
    }
}
