class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price - min > answer) {
                answer = price - min;
            }
            
            if (price < min) {
                min = price;
            }
        }

        return answer;
    }
}

/**
 *  
 *
 */