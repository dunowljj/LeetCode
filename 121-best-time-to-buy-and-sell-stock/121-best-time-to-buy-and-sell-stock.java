class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = 10001;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > buy) {
                 maxProfit = Math.max(maxProfit, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}