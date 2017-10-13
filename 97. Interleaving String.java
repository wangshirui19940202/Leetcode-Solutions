    // 97. Interleaving String

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray(), ss3 = s3.toCharArray();
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) 
            if (ss1[i] == ss3[i]) dp[i + 1][0] = true;
            else break;
        for (int i = 0; i < s2.length(); i++)
            if (ss2[i] == ss3[i]) dp[0][i + 1] = true;
            else break;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i + 1][j + 1] = (ss3[i + j + 1] == ss1[i] && dp[i][j + 1]) || (ss3[i + j + 1] == ss2[j] && dp[i + 1][j]);
            }
        }
        
        return dp[s1.length()][s2.length()];
    }