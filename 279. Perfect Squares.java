    // 279. Perfect Squares
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int c = 1; c <= i; c++) {
                int mul = c * c;
                if(mul > i) break;
                dp[i] = Math.min(dp[i], 1 + dp[i - mul]);
            }
        }
        return dp[n];
    }
    
    