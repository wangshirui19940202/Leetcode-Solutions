    // 416. Partition Equal Subset Sum
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i : nums) {
            for (int t = sum - i; t >= 0; t--) {
                if (dp[t]) dp[t + i] = true;
            }
            if (dp[sum]) return true;
        }
        return false;
    }