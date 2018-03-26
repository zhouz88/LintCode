class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        int total = n;
        boolean left = true;
        while (total > 1) {
            if (left) {
                head = head + step;
            } else if (total% 2 ==1) {
                head = head + step;
            }
            step *= 2;
            total /= 2;
            left = !left;
        }
        return head;
    }
}
