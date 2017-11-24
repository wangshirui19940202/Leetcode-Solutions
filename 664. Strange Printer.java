    // 664. Strange Printer

    public int strangePrinter(String s) {
        if (s.length() == 0) return 0;
        char[] ss = s.toCharArray();
        int[][] dp = new int[ss.length + 1][ss.length + 1];
        for (int i = ss.length - 1; i >= 0; i --) { // start
            dp[i + 1][i + 1] = 1;
            for (int j = i + 1; j < ss.length; j++) { // end 
                dp[i + 1][j + 1] = dp[i + 1][j] + 1;
                for (int k = i; k < j; k++)
                    if (ss[j] == ss[k])
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 1][k] + dp[k + 1][j]);
            }
        }
        return dp[1][ss.length];
    }
    