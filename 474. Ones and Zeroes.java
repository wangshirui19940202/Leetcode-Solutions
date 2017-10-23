    // 474. Ones and Zeroes
    
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int z = 0, o = 0;
            for (char c : s.toCharArray())
                if (c == '0') z ++;
                else o ++;
            for (int i = m; i >= z; i--)
                for (int j = n; j >= o; j--)
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - z][j - o]);
        }
        return dp[m][n];
    }