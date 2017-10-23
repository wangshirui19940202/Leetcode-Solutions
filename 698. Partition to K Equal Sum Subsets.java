    // 698. Partition to K Equal Sum Subsets

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % k != 0) return false;
        int[] dp = new int[k];
        sum /= k;
        Arrays.fill(dp, sum);
        Arrays.sort(nums);
        return backtrack(dp, nums, nums.length - 1);
    }
    private boolean backtrack(int[] dp, int[] nums, int cur) {
        if (cur == -1) return true;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] - nums[cur] >= 0) { 
                dp[i] -= nums[cur];
                if (backtrack(dp, nums, cur - 1))
                    return true;
                dp[i] += nums[cur];
            }
        }
        return false;
    }
    