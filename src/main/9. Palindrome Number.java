class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int total = 0;
        int y = x;
        while (y != 0) {
            total = y%10 + total * 10;
            y /= 10;
        }
        return total == x;
    }
}
