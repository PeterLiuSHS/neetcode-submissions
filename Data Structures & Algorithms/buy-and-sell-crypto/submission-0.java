class Solution {
    public int maxProfit(int[] prices) {
        int maxPft = 0;
        for (int buyday = 0; buyday < prices.length; buyday++) {
            for (int sellday = buyday; sellday < prices.length; sellday++) {
                int prf = prices[sellday] - prices[buyday];
                maxPft = Math.max(maxPft, prf);
            }
        }
        return maxPft;
    }
}
