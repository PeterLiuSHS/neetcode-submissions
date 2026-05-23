class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int sell = 1; sell<prices.length; sell++){
            int profit = prices[sell]-minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[sell]);
            // sell身兼数职，一边在记录出售日，一边参与更新买入日
        }
        return maxProfit;
    }
}
