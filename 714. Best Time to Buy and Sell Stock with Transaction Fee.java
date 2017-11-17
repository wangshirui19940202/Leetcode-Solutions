    // 714. Best Time to Buy and Sell Stock with Transaction Fee
    
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length], sell = new int[prices.length];
        buy[0] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(buy[i - 1] + prices[i] - fee, sell[i - 1]);
        }
        return sell[prices.length - 1];
    }