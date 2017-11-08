    // 309. Best Time to Buy and Sell Stock with Cooldown

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int sell = 0, rest = 0, buy = -prices[0];
        for (int i : prices) {
            int t = sell;
            sell = Math.max(buy + i, sell);
            buy = Math.max(buy, rest - i);
            rest = Math.max(t, rest);
        }
        return Math.max(rest, sell);
    }
    /*
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] rest = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        rest[0] = 0;
        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            rest[i] = Math.max(sell[i - 1], rest[i - 1]);
            buy[i] = Math.max(rest[i - 1] - prices[i], buy[i - 1]);
            sell[i] = buy[i - 1] + prices[i];
        }
        return Math.max(sell[sell.length - 1], rest[rest.length - 1]);
    }
    */