    // 518. Coin Change 2
    
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // Arrays.sort(coins); //no need for sort
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(j < coins[i]) continue;
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }