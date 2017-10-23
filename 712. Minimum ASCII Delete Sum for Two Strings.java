    // 712. Minimum ASCII Delete Sum for Two Strings
    
    public int minimumDeleteSum(String s1, String s2) {
        char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray();
        int[][] dp = new int[ss1.length + 1][ss2.length + 1];
        for (int i = 1; i <= ss1.length; i++) dp[i][0] = ss1[i - 1] + dp[i - 1][0];
        for (int i = 1; i <= ss2.length; i++) dp[0][i] = ss2[i - 1] + dp[0][i - 1];
        for (int i = 0; i < ss1.length; i++) 
            for (int j = 0; j < ss2.length; j++)
                if (ss1[i] == ss2[j]) dp[i + 1][j + 1] = dp[i][j];
                else dp[i + 1][j + 1] = Math.min(ss1[i] + ss2[j] + dp[i][j], Math.min(ss1[i] + dp[i][j + 1], ss2[j] + dp[i + 1][j]));
        return dp[ss1.length][ss2.length];
    }