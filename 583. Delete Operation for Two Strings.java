    // 583. Delete Operation for Two Strings

    public int minDistance(String word1, String word2) {
        char[] ss1 = word1.toCharArray(), ss2 = word2.toCharArray();
        int[][] dp = new int[ss1.length + 1][ss2.length + 1];
        for (int i = 0; i < ss1.length; i++)
            for (int j = 0; j < ss2.length; j++) {
                if (ss1[i] == ss2[j]) dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        return ss1.length + ss2.length - 2 * dp[ss1.length][ss2.length];
    }