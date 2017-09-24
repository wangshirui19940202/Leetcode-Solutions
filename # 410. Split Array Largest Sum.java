    // 410. Split Array Largest Sum

    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[m][nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[0][i] = sum;
        }
        for(int i = 1; i < m; i++) {
            for(int j = i; j < nums.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], dp[0][j] - dp[0][k]));
            }
        }
        return dp[m - 1][nums.length - 1];
    }