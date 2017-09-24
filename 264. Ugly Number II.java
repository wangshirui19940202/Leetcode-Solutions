    // 264. Ugly Number II

    public int nthUglyNumber(int n) {
        int[] count = new int[3];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int mul2 = dp[count[0]] * 2, mul3 = dp[count[1]] * 3, mul5 = dp[count[2]] * 5;
            int min = Math.min(mul2, Math.min(mul3, mul5));
            dp[i] = min;
            if(min == mul2) count[0]++;
            if(min == mul3) count[1]++;
            if(min == mul5) count[2]++;
        }
        return dp[n - 1];
    }