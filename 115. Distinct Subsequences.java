    // 115. Distinct Subsequences

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        char[] ss = s.toCharArray(), ts = t.toCharArray();
        for (int i = 0; i <= s.length(); i++) dp[i][0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length() && j <= i; j++) {
                if (ss[i] == ts[j])
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                else 
                    dp[i + 1][j + 1] = dp[i][j + 1];
            }
        }
        return dp[ss.length][ts.length];
    }