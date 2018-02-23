class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
       int len = prices.length;
       int[] leftDp = new int[len];
       int[] rightDp = new int[len];
       int min = prices[0];
        
       for (int i = 1; i < len; i++) {
           leftDp[i] = Math.max(prices[i] - min, leftDp[i - 1]);
           min = Math.min(prices[i], min);
       }
        
       int max = prices[len - 1];
        
       for (int i = len - 2; i >= 0; i--) { //bug 2
           rightDp[i] = Math.max(rightDp[i + 1], max - prices[i]);
           max = Math.max(prices[i], max);
       }
        
       max = rightDp[0]; //bug1
        
       for (int i = 0; i < len - 1; i++) {
           max = Math.max(leftDp[i] + rightDp[i + 1], max);
       }
       return max;
    }
}
