    // 650. 2 Keys Keyboard
    
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
    
    /*
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j < i; j++) 
                if (i % j == 0)
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
        }
        return dp[n];
    }
    */