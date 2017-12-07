public class Solution {
    /*
     * @param prices: Given an integer array
     * @return: Maximum profit
     151. Best Time to Buy and Sell Stock III 

 Description
 Notes
 Testcase
 Judge
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Notice

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Have you met this question in a real interview? Yes
Example
Given an example [4,4,6,1,1,4,2,5], return 6.
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int min = prices[0];
        int[] fmin = new int[n];
        fmin[1] = prices[1] - prices[0] >= 0 ? prices[1] - prices[0] : 0; 
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            fmin[i] = Math.max(fmin[i - 1], prices[i] - min);
            fmin[i] = Math.max(fmin[i], 0);
        }
        int max = prices[n - 1];
        int[] fmax = new int[n];
        fmax[n - 2] = prices[n - 2] - prices[n - 1] >= 0 ? prices[n - 2] - prices[n - 1] : 0; 
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            fmax[i] = Math.max(fmax[i + 1], max - prices[i]);
            fmax[i] = Math.max(fmax[i], 0);
        }
        int res = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            res = Math.max(res, fmax[i + 1] + fmin[i]);
        }
        res = Math.max(res, fmin[n - 1]);
        return res;
    }
}
