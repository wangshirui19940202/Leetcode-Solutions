    // 72. Edit Distance

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] ss1 = word1.toCharArray(), ss2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(ss1[i] == ss2[j])
                    dp[i + 1][j + 1] = dp[i][j];
                else 
                    dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, Math.min(dp[i][j + 1] + 1, dp[i + 1][j] + 1));
            }
        }
        return dp[m][n];
    }