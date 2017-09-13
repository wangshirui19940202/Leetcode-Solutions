
    // 312. Burst Balloons
    // dp[l][r] means the maximum score between l and r exlusively 
    
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length + 2];
        num[0] = 1;
        num[num.length - 1] = 1;
        for(int i = 1; i < num.length - 1; i++)
            num[i] = nums[i - 1];
        int[][] dp  = new int[num.length][num.length];
        return dfs(num, dp, 0, num.length - 1);
    }
    private int dfs(int[] nums, int[][] dp, int l, int r) {
        if(l + 1 == r) return 0;
        if(dp[l][r] != 0) return dp[l][r];
        int res = 0;
        for(int i = l + 1; i < r; i++) {
            res = Math.max(res, nums[l] * nums[r] * nums[i] + (dfs(nums, dp, l, i) + dfs(nums, dp, i, r)));
        }
        dp[l][r] = res;
        return res;
    }