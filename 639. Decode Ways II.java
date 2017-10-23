    // 639. Decode Ways II

    public int numDecodings(String s) {
        final int MOD = 1000000007;
        char[] ss = s.toCharArray();
        long dp2 = 1, dp1 = ss[ss.length - 1] == '0' ? 0 : ss[ss.length - 1] == '*' ? 9 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            long cur = 0;
            if (ss[i] == '0') cur = 0;
            else if (ss[i] == '*') {
                // ss[i + 1]=='*'-> (9+6)*dp[i+2] +9*dp[i+1]   ss[i + 1]<=6 ->9*dp[i+1]+2*dp[i+2]   ss[i+1]>6 -> 9*dp[i+1]
                cur = ss[i + 1] == '*' ? 15 * dp2 + 9 * dp1 : ss[i + 1] > '6' ? 9 * dp1 + dp2 : 9 * dp1 + 2 * dp2;
            } else if (ss[i] == '2') {
                cur = ss[i + 1] == '*' ? 6 * dp2 + dp1 : ss[i + 1] > '6' ? dp1 : dp1 + dp2;
            } else if (ss[i] == '1') {
                cur = ss[i + 1] == '*' ? 9 * dp2 + dp1 : dp1 + dp2;
            } else 
                cur = dp1;
            dp2 = dp1;
            dp1 = cur % MOD;
        }
        return (int)dp1;
    }
    
    
    
    /*
    public int numDecodings(String s) {
        char[] ss = s.toCharArray();
        long[] dp = new long[ss.length + 1];
        int MOD = 1000000007;
        
        dp[ss.length] = 1;
        dp[ss.length - 1] = ss[ss.length - 1] == '0' ? 0 : ss[ss.length - 1] == '*' ? 9 : 1;
        
        for(int i = ss.length - 2; i >= 0; i--){
            if(ss[i] == '0')
                dp[i] = 0;
            else if(ss[i] == '*') {
                if(ss[i + 1] == '*')
                    dp[i] = dp[i + 1] * 9 + dp[i + 2] * 15;
                else if(ss[i + 1] <= '6')
                    dp[i] = dp[i + 2] * 2 + dp[i + 1] * 9; 
                else 
                    dp[i] = dp[i + 1] * 9 + dp[i + 2];
            } else if(ss[i + 1] == '*'){
                if(ss[i] == '1')
                    dp[i] = dp[i + 1] + dp[i + 2] * 9;
                else if(ss[i] == '2')
                    dp[i] = dp[i + 1] + dp[i + 2] * 6;
                else
                    dp[i] = dp[i + 1];
            } else{
                if(ss[i] == '1' || (ss[i] == '2' && ss[i + 1] <= '6'))
                    dp[i] = dp[i + 1] + dp[i + 2];
                else
                    dp[i] = dp[i + 1];
            }
            dp[i] = dp[i] % MOD;
        }
        return (int)dp[0];
    }
    */