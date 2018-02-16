class Solution {
    public int longestPalindrome(String s) {
        int[] t = new int[256];
        for (char ch : s.toCharArray()) {
            t[ch]++;
        }
        int total = 0;
        int cntOfOdd = 0;
        for (int k : t) {
            if (k != 0 && (k & 1) == 0) {
                total += k;
            } else if ((k & 1) == 1) {
                cntOfOdd++;
                total += k - 1;
            }
        }
        if (cntOfOdd > 0) {
            total += 1;
        }
        return total;
    }
}
