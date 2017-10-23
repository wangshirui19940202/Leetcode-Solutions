    // 91. Decode Ways
    // String.substring() to chekc if the string is smaller than 26
    // only need n + 1 and n + 2, so space could be O(1) instead of O(N)
    
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        char[] ss = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = ss[s.length() - 1] == '0' ? 0 : 1;
        for (int i = ss.length - 2; i >= 0; i--) {
            if (ss[i] == '0') continue;
            else {
                dp[i] = Integer.valueOf(s.substring(i, i + 2)) <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        return dp[0];
    }