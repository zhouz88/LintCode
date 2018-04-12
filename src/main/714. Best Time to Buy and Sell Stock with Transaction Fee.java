class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int[] endsWithMax = new int[prices.length];
        int[] end = new int[prices.length];
        endsWithMax[0] = -prices[0];
        end[0] = 0;
        int max = end[1];
        for (int i = 1; i < prices.length; i++) {
            end[i] = Math.max(prices[i] + endsWithMax[i - 1] - fee, end[i - 1]);
            endsWithMax[i] = Math.max(end[i - 1] - prices[i], endsWithMax[i - 1]);
        }
        return end[prices.length - 1];
    }
}
