    // 300. Longest Increasing Subsequence

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i : nums) {
            /*int l = 0, r = res;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (dp[m] < i) {
                    l = m + 1;
                } else 
                    r = m;
            }
            dp[l] = i;
            if (res == l) res++;
            */
            int p = Arrays.binarySearch(dp, 0, res, i);
            if (p < 0)
                p = -p - 1;
            dp[p] = i;
            if (p == res) res++;
        }
        return res;
    }
    
    /*
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            res = Math.max(res, ++dp[i]);
        }
        return res;
    }
    */