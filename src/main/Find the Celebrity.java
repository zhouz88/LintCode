public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (knows(ans, i)) {
                ans = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == ans) {
                continue;
            }
            if (knows(i, ans) && !knows(ans, i)) {
                continue;
            } else {
                return -1;
            }
        }
        return ans;
    }
    
    public boolean knows(int a, int b) {
        return true;   
    }
}
