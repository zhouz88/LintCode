public class Solution {
    /*
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
     
     /*
     394. Coins in a Line 

 Description
 Notes
 Testcase
 Judge
There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.

Could you please decide the first play will win or lose?

Have you met this question in a real interview? Yes
Example
n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.
     
     
     
     */
    public boolean firstWillWin(int n) {
        // write your code here
        boolean[] dp = new boolean[1000000];
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] == false || dp[i - 2] == false) ? true : false;
        }
        return dp[n];
    }
}


public class Solution {
    /*
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n == 0) {
            return false;
        }
        if (n <= 2) {
            return true;
        }
        boolean pre1 = true;
        boolean pre2 = true;
        boolean win = false;
        for (int i = 3; i <= n; i++) {
            win = !pre1 || !pre2;
            pre2 = pre1;
            pre1 = win;
        }
        return win;
    }
}
