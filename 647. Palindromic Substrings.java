    // 647. Palindromic Substrings

    public int countSubstrings(String s) {
        if (s.length() <= 1) return s.length();
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < ss.length; i++) {
            dp[i][i] = true;
            res++;
            for (int j = i - 1; j >= 0; j--) {
                if (ss[i] == ss[j] && (i - j < 3 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    res++;
                }
            }
        }
        return res;
    }