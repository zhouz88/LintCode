public class Solution {
    /*
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
     
     /*
     437. Copy Books 

 Description
 Notes
 Testcase
 Judge
Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?
     
     
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int n = pages.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[k][n];
        int[] sum = new int[n + 1];
        int[] tomax = new int[n];
        tomax[0] = pages[0];
        for (int i = 1; i < n; i++) {
            tomax[i] = Math.max(tomax[i - 1], pages[i]);
        }
        if (k >= n) {
            return tomax[n - 1];
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + pages[i - 1];
        }
        int[] tmp = dp[0];
        tmp[0] = pages[0];
        for (int i = 1; i <= n - 1; i++){
            tmp[i] = tmp[i - 1] + pages[i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = i; j < n; j++) {
                if (j == i) {
                    dp[i][j] = tomax[i];
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int t = i - 1; t < j; t++) {
                   int p = Math.max(dp[i - 1][t],  sum[j + 1] - sum[t + 1]);
                   dp[i][j] = Math.min(dp[i][j], p);
                }
            }
        }
        return dp[k - 1][n - 1];
    }
}


public class Solution {
    /*
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int n = pages.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int[] sum = new int[n + 1];
        int[] tomax = new int[n];
        tomax[0] = pages[0];
        for (int i = 1; i < n; i++) {
            tomax[i] = Math.max(tomax[i - 1], pages[i]);
        }
        if (k >= n) {
            return tomax[n - 1];
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + pages[i - 1];
        }
        int[] tmp = dp;
        tmp[0] = pages[0];
        for (int i = 1; i <= n - 1; i++){
            tmp[i] = tmp[i - 1] + pages[i];
        }
        for (int i = 1; i < k; i++) {
            int[] ndp = new int[n];
            for (int j = i; j < n; j++) {
                if (j == i) {
                    ndp[j] = tomax[i];
                    continue;
                }
                ndp[j] = Integer.MAX_VALUE;
                for (int t = i - 1; t < j; t++) {
                   int p = Math.max(dp[t],  sum[j + 1] - sum[t + 1]);
                   ndp[j] = Math.min(ndp[j], p);
                }
            }
            dp = ndp;
        }
        return dp[n - 1];
    }
}
