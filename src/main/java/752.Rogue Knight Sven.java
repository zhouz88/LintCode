public class Solution{
/*
 752. Rogue Knight Sven
//
    Description
    Notes
    Testcase
    Judge

This problem is in a contest: Weekly Contest #1 . Submit your code and see your ranking!

In material plane "reality", there are n + 1 planets, namely planet 0, planet 1, ..., planet n.
Each planet has a portal through which we can reach the target planet directly without passing through other planets.
But portal has two shortcomings.
First, planet i can only reach the planet whose number is greater than i, and the difference between i can not exceed the limit.
Second, it takes cost[j] gold coins to reach the planet j through the portal.
Now, Rogue Knight Sven arrives at the planet 0 with m gold coins, how many ways does he reach the planet n through the portal?
Notice

    1 <= n <= 50, 0 <= m <= 100, 1 <= limit <= 50,0 <= cost[i] <= 100。
    The problem guarantees cost [0] = 0, cause cost[0] does not make sense

Have you met this question in a real interview?
Example
*/
    public long getNumberOfWays(int n, int m, int limit, int[] costs) {
       for (int i = 0; i <= 50; i++) {
           Arrays.fill(dp[i], -1);
       }
       return dfs(0, m, limit, costs, n);
    }
    long[][] dp = new long[51][101];
    
    private long dfs(int start, int total, int limit, int[] costs, int n) {
        if (start == n) {
            return 1;
        }
        if (dp[start][total] != -1) {
            return dp[start][total];
        }
        long sum = 0;
        for (int i = start + 1; i <= Math.min(n, start+limit); i++) {
            if (total >= costs[i]) {
                long p = dfs(i, total-costs[i], limit, costs, n);
                if (p > 0) sum += p;
            }
        }
        dp[start][total] = sum;
        return sum;
    }
}
