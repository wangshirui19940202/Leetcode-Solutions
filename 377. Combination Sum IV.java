
    // 377. Combination Sum IV
    // sorting makes it faster
    
    public int combinationSum4(int[] nums, int target) {
        int[] dp =new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for(int i = 1; i <= target; i++) {
            for(int j : nums) {
                if(j > i) break;
                dp[i] += dp[i - j];
            }
        }
        return dp[target];
    }